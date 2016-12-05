package Undergraduate_Project;
import Undergraduate_Project.Floor;
import Undergraduate_Project.Piston;
import Undergraduate_Project.FloorPanelState;
import Undergraduate_Project.EmergencyBreaks;

import java.util.Comparator;
import java.util.PriorityQueue;
public class ControlSystem {
	private final int NUMBER_OF_FLOORS = 5;
	private final int INITIAL_ELEVATOR_FLOOR = 1;
	private static boolean DOOR_OPEN;
	
	//Used for comparator class
	//public enum Piston{MOVING_UP, STATIONARY, MOVING_DOWN}
	public Piston object;
	public FloorPanelState state;
	
	//Floor Objects
	public Floor []floor;
	
	//EM Brake Object
	public EmergencyBreaks brake = new EmergencyBreaks();
	
	//Queue
	public Comparator<Floor> comparator = new ElevatorQueue();
	public PriorityQueue<Floor> queue = new PriorityQueue<Floor>(5, comparator);
	
	public ElevatorCar elevatorCar = new ElevatorCar();
	public ElevatorCarPiston piston = new ElevatorCarPiston(INITIAL_ELEVATOR_FLOOR, NUMBER_OF_FLOORS);
 	ControlSystem(){
		for(int i = 0; i < NUMBER_OF_FLOORS; i++)
			floor[i] = new Floor(i);	
	}
	/*
	 * Develop function to receive calls from Floor Panels. Then push the floor
	 * object to the queue.
	 *	-> queue.add(<floor object>) //Adds object to Queue
	 *	-> queue.remove(<floor object>) //Removes object from Queue
	 *	-> queue.clear() //Clears Queue
	 * 
	 * 	Always add the next highest or lowest floor first. 
	 */
	public void checkForFloorInput(){
		for(int i = 0; i < NUMBER_OF_FLOORS; i++){
			if(floor[i].getFloorPanelState() != 0)
				queue.add(floor[i]);
		}
	}
	
	public void removeFloorFromQueue(Floor obj){
		queue.remove(obj);
	}
	
	public void clearQueue(){
		queue.clear();	
	}
	
	int moveToFloor(int targetFloor) {
		int currentFloor = piston.movePistonToFloor(targetFloor);
		return currentFloor;
	}
	
	public double getElevatorSpeed(){
		return piston.getSpeed();
	}
	
	public void speedSafety(){
		if(piston.getSpeed() > 2.0)
			this.EM_Brake_Procedure();
	}
	
	public void EM_Brake_Procedure(){
		brake.setBreaks(true);
		while(piston.getSpeed() > 0.0){
			piston.deacceleration();
			if(piston.getSpeed() <= 0.0)
				piston.setSpeed(0.0);
		}
		//Implement function to move elevator to closest floor
		brake.setBreaks(false);
		piston.resetSpeed();
	}
	
	//Opening Floor Door and elevator Door when destination is reached
	public void door_function(){
		//If elevator is still moving deny call to open door
		if(piston.getPistonState() != object.STATIONARY)
			break;
		//Check floor sensor. If piston position equals floor position then open floor door and elevator door
		if(piston.getCurrentPosition() == piston.getDestinationFloor()){
			elevatorCar.setDoorOpen();
			floor[piston.getCurrentFloor].setDoorOpen();
		}
	}
	
	public class ElevatorQueue extends ControlSystem implements Comparator<Floor> {//May have to add function to check postion of floors compared to each other
		
		public int compare(Floor obj1, Floor obj2){
			if(piston.getPistonState() == object.MOVING_UP){
				if(obj1.getFloorPanelState() > obj2.getFloorPanelState())
					return 1;
				if(obj1.getFloorPanelState() < obj2.getFloorPanelState())  
					return -1;
				if(obj1.floorPosition < obj2.floorPosition && obj1.returnPanelStatus() == state.UP && obj1.floorPosition > piston.getCurrentPosition())
					return 1;
				else if(obj2.returnPanelStatus() == state.UP && obj2.floorPosition > piston.getCurrentPosition())
					return -1;
			
			}
			if(piston.getPistonState() == object.MOVING_DOWN){
				if(obj1.getFloorPanelState() < obj2.getFloorPanelState())
					return 1;
				if(obj1.getFloorPanelState() > obj2.getFloorPanelState())
					return -1;
				if(obj1.floorPosition > obj2.floorPosition && obj1.returnPanelStatus() == state.DOWN && obj1.floorPosition < piston.getCurrentPosition())
					return 1;
				else if(obj2.returnPanelStatus() == state.DOWN && obj2.floorPosition < piston.getCurrentPosition())
					return -1;
			}
			if(piston.getPistonState() == object.STATIONARY)
				return 1;
			return 0;
		}
	}

}
