package Undergraduate_Project;
import Undergraduate_Project.Floor;
import Undergraduate_Project.Piston;
import java.uitl.*;
public class ControlSystem {
	private final int NUMBER_OF_FLOORS = 5;
	private final int INITIAL_ELEVATOR_FLOOR = 1;
	private static boolean DOOR_OPEN;
	
	//Used for comparator class
	//public enum Piston{MOVING_UP, STATIONARY, MOVING_DOWN}
	public Piston object;
	
	//Floor Objects
	public Floor f1 = new Floor(1);
	public Floor f2 = new Floor(2);
	public Floor f3 = new Floor(3);
	public Floor f4 = new Floor(4);
	public Floor f5 = new Floor(5);
	public Comparator<Floor> comparator;
	public PriorityQueue<Floor> queue;
 	ControlSystem(){
		comparator = new ElevatorQueue();
		queue = new PriorityQueue<Floor>(5, comparator);
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
	
	ElevatorCarPiston piston = new ElevatorCarPiston(INITIAL_ELEVATOR_FLOOR, 
			NUMBER_OF_FLOORS);
	int moveToFloor(int targetFloor) {
		int currentFloor = piston.movePistonToFloor(targetFloor);
		return currentFloor;
	}
}
//Comparator Class
	public class ElevatorQueue implements Comparator<Floor>{//May have to add function to check postion of floors compared to each other
		@Override
		public int compare(Floor obj1, Floor obj2){
			if(piston.getPistonState() == object.MOVING_UP){
				if(obj1.getFloorPanelState() > obj2.getFloorPanelState())
					return 1;
				if(obj1.getFloorPanelState() < obj2.getFloorPanelState())
					return -1;
			}
			if(piston.getPistonState() == object.MOVING_DOWN){
				if(obj1.getFloorPanelState() < obj2.getFloorPanelState())
					return 1;
				if(obj1.getFloorPanelState() > obj2.getFloorPanelState())
					return -1;
			}
			if(piston.getPistonState() == object.STATIONARY)
				return 1;
			return 0;
		}
	}
