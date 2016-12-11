package Undergraduate_Project;
import Undergraduate_Project.Piston;
public class ElevatorCarPiston {
	private int currentFloor;
	private int lastFloor;
	private int destinationFloor;
	public int[] path = new int[5];
	
	//General object for piston
	public Object piston = new Object();
	//Time variables for pistonMove()
	public long begin_time = System.nanoTime();
	public double up_time = 0.0;
	public double down_time = 0.0;
	//Position variable for pistonMove()
	public double floorPosition = destinationFloor * 10.0;
	public double currentPosition = 0.0;
	
	//Speed of elevator system
	public double elevator_speed = 2.0;
	
	//Different states for piston object
	//public enum Piston{MOVING_UP, STATIONARY, MOVING_DOWN}
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
		currentFloor = (int)(this.getCurrentPosition()/10.0) + 1;
		return currentFloor;
	}
	
	public double path_pos(int i){
		return path[i] *10;
	}
	
	public int[] array(){
		return path;
	}
	
	public int getDestinationFloor() {
		return destinationFloor;
	}
	
	public double getCurrentPosition(){
		return currentPosition;
	}
	
	public double getFloorPosition(){
		return floorPosition;	
	}
	
	// Mutator
	public void setCurrnetFloor(int floor) {
		currentFloor = floor;
	}
	
	public void setDestinationFloor(int floor) {
		destinationFloor = floor+1;
		//System.out.println("Destination Floor: "+destinationFloor);
		floorPosition = destinationFloor *10.0 - 10;
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
	
	public void setCurrentPosition(double x){
		currentPosition = x;	
	}
	
	//Mutator for Piston State
	public void setPistonState(Piston state){
		object = state;
	}
	
	//Getter for Piston State
	public Object getPistonState(){
		return piston;
	}
	public void resetSpeed(){
		elevator_speed = 2.0;	
	}
	
	public void setSpeed(double value){
		elevator_speed = value;	
	}
	
	public double getSpeed(){
		return elevator_speed;	
	}
	
	public void piston_main() throws InterruptedException{
		if(currentPosition < floorPosition){
			piston = object.MOVING_UP;
			//System.out.println("Set to up");
			//Thread.sleep(1000);
			up_time = time_sec();
			down_time = time_sec();
			this.pistonMove();
			//System.out.println("Position: "+currentPosition);
		}
			
		else if(currentPosition > floorPosition){
			piston = object.MOVING_DOWN;
			//Thread.sleep(1000);
			up_time = time_sec();
			down_time = time_sec();
			this.pistonMove();
		}
		else{
			piston = object.STATIONARY;
		}
	}
	
	//Calculates the position of the Piston with respect to time and speed
	public double pistonMove() throws InterruptedException{
		Thread.sleep(1000);
		if(piston == object.MOVING_UP){
			//System.out.println("moving up");
			up_time = time_sec();
			//up_time++
			//System.out.println(time_sec());
			currentPosition = currentPosition + elevator_speed * Math.abs((up_time - down_time));
		}else if(piston == object.MOVING_DOWN){
			down_time = time_sec();
			currentPosition = currentPosition - elevator_speed * Math.abs((up_time - down_time));
		}else{
			up_time = time_sec();
			down_time = time_sec();
		}
		return currentPosition;
	}
	
	//Converts system time to seconds
	public double time_sec(){
		long elap_time = System.nanoTime() - begin_time;
		return (double)(elap_time / 1000000000);
	}
	
	public void deacceleration(){//Prototype function for elevator deacceleration
		if (Math.abs(currentPosition-floorPosition) <= 2.0)
			elevator_speed = elevator_speed/2.0;
	}
}
