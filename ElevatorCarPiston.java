package elevatorProject;

public class ElevatorCarPiston {
	private int currentFloor;
	private int lastFloor;
	private int destinationFloor;
	
	//General object for piston
	public Object piston = new Object();
	//Time variables for pistonMove()
	public long begin_time = System.nanoTime();
	public double up_time = 0;
	public double down_time = 0;
	//Position variable for pistonMove()
	public double currentPosition = 0;
	
	//Different states for piston object
	public enum Piston{MOVING_UP, STATIONARY, MOVING_DOWN}
	public Piston object;
	
	// Default Constructor
	ElevatorCarPiston() {
		currentFloor = 1;
		lastFloor = 2;
		destinationFloor = currentFloor;
		piston = object.STATIONARY;
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
	public void setPistonState(Piston state){
		object = state;
	}
	
	//Getter for Piston State
	public Piston getPistonState(){
		return object;
	}
	
	//Calculates the position of the Piston with respect to time and speed
	public double pistonMove(){	
		if(piston == object.MOVING_UP){
			up_time = time_sec();
			currentPosition = currentPosition + 2.0 * Math.abs((up_time - down_time));
		}else if(piston == object.MOVING_DOWN){
			down_time = time_sec();
			currentPosition = currentPosition - 2.0 * Math.abs((up_time - down_time));
		}else{
			/*
			 * May need to add functions if piston stationary state breaks calculations
			 */
		}
		return currentPosition;
	}
	
	//Converts system time to seconds
	public double time_sec(){
		long elap_time = System.nanoTime() - begin_time;
		return (double)(elap_time / 1000000000);
	}
}
