package elevatorProject;

public class ControlSystem {
	private final int NUMBER_OF_FLOORS = 5;
	private final int INITIAL_ELEVATOR_FLOOR = 1;
	private static boolean DOOR_OPEN;
	
 	ControlSystem(){	
	};
	
	ElevatorCarPiston piston = new ElevatorCarPiston(INITIAL_ELEVATOR_FLOOR, 
			NUMBER_OF_FLOORS);
	int moveToFloor(int targetFloor) {
		int currentFloor = piston.movePistonToFloor(targetFloor);
		return currentFloor;
	}
}
