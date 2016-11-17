package Undergraduate_Project;
import Undergraduate_Project.Floor;
import Undergraduate_Project.Piston;

import java.util.Comparator;
import java.util.PriorityQueue;
public class ControlSystem {
	private final int NUMBER_OF_FLOORS = 5;
	private final int INITIAL_ELEVATOR_FLOOR = 1;
	private static boolean DOOR_OPEN;
	
	//Used for comparator class
	//public enum Piston{MOVING_UP, STATIONARY, MOVING_DOWN}
	public Piston object;
	
	//Floor Objects
	public Floor []floor;
	
	
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
	
	int moveToFloor(int targetFloor) {
		int currentFloor = piston.movePistonToFloor(targetFloor);
		return currentFloor;
	}
	
	public class ElevatorQueue extends ControlSystem implements Comparator<Floor> {//May have to add function to check postion of floors compared to each other
		
		public int compare(Floor obj1, Floor obj2){
			if(piston.getPistonState() == object.MOVING_UP){
				if(obj1.getFloorPanelState() > obj2.getFloorPanelState())
					return 1;
				if(obj1.getFloorPanelState() < obj2.getFloorPanelState())  
					return -1;
				if(obj1.floorPosition < obj2.floorPosition)
					return 1;
				else
					return -1;
			
			}
			if(piston.getPistonState() == object.MOVING_DOWN){
				if(obj1.getFloorPanelState() < obj2.getFloorPanelState())
					return 1;
				if(obj1.getFloorPanelState() > obj2.getFloorPanelState())
					return -1;
				if(obj1.floorPosition > obj2.floorPosition)
					return 1;
				else
					return -1;
			}
			if(piston.getPistonState() == object.STATIONARY)
				return -1;
			return 0;
		}
	}

}
