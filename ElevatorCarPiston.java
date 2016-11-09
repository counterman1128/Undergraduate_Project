package elevatorProject;

public class ElevatorCarPiston {
	private int currentFloor;
	private int lastFloor;
	private int destinationFloor;
	
	//Time variables for pistonMove()
	public static double up_time = 0;
	public static double down_time = 0;
	//Position variable for pistonMove()
	public static double currentPosition = 0;
	
	//Different states for piston object
	public static enum Piston{MOVING_UP, STATIONARY, MOVING_DOWN}
	public static Piston object;
	
	// Default Constructor
	ElevatorCarPiston() {
		currentFloor = 1;
		lastFloor = 2;
		destinationFloor = currentFloor;
		this = object.STATIONARY;
	}
	
	// ElevatorCarPist(int, int)
	ElevatorCarPiston(int initialFloor, int maxFloor) {
		currentFloor = initialFloor;
		lastFloor = maxFloor;
		destinationFloor = initialFloor;
	}
	
	// Accessor
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public int getDestinationFloor() {
		return destinationFloor;
	}
	
	// Mutator
	public void setCurrnetFloor(int floor) {
		currentFloor = floor;
	}
	
	public void setDestinationFloor(int floor) {
		destinationFloor = floor;
	}
	
	public int movePistonToDestinationFloor() {
		if (destinationFloor <= lastFloor){
			currentFloor = destinationFloor;
			return currentFloor;
		} else {
			currentFloor = lastFloor;
			return currentFloor;
		}
	}
	
	public int movePistonToFloor(int targetFloor) {
		if (targetFloor <= lastFloor) {
			currentFloor = targetFloor;
			return currentFloor;
		} else {
			currentFloor = lastFloor;
			return currentFloor;
		}
	}
	
	public boolean sentPistonToFirstFloor() {
		currentFloor = 1;
		return true;
	}
	
	//Mutator for Piston State
	public static void setPistonState(Piston state){
		this = object.state;
	}
	
	//Getter for Piston State
	public static Piston(){
		return object;
	}
	
	//Calculates the position of the Piston with respect to time and speed
	public static double pistonMove(){	
		if(this == object.MOVING_UP){
			up_time = time_sec();
			currentPosition = currentPosition + 2.0 * Math.abs((up_time - down_time));
		}else if(this == object.MOVING_DOWN){
			down_time = time_sec();
			currentPosition = currentPosition - 2.0 * Math.abs((up_time - down_time));
		}
		return currentPosition;
	}
	
	//Converts system time to seconds
	public static double time_sec(){
		long elap_time = sys_time() - begin_time;
		return (double)(elap_time / 1000000000);
	}
}
