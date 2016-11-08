package elevatorProject;

public class ElevatorCarPiston {
	private int currentFloor;
	private int lastFloor;
	private int destinationFloor;
	
	// Default Constructor
	ElevatorCarPiston() {
		currentFloor = 1;
		lastFloor = 2;
		destinationFloor = currentFloor;
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
	
	public boolean sentPistonToFisrtFloor() {
		currentFloor = 1;
		return true;
	}
}
