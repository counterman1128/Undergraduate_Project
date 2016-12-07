package Undergraduate_Project;
import Undergraduate_Project.Piston;
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
	public double floorPosition = destinationFloor * 10 - 10;
	public double currentPosition = 0;
	
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
		return currentFloor;
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
	
	public void piston_main(){
		if(currentPosition < floorPosition)
			piston = object.MOVING_UP;
		else if(currentPosition > floorPosition)
			piston = object.MOVING_DOWN;
		else
			piston = object.STATIONARY;
	}
	
	//Calculates the position of the Piston with respect to time and speed
	public double pistonMove(){	
		if(piston == object.MOVING_UP){
			up_time = time_sec();
			currentPosition = currentPosition + elevator_speed * Math.abs((up_time - down_time));
		}else if(piston == object.MOVING_DOWN){
			down_time = time_sec();
			currentPosition = currentPosition - elevator_speed * Math.abs((up_time - down_time));
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
	
	public void deacceleration(){//Prototype function for elevator deacceleration
		if (Math.abs(currentPosition-floorPosition) <= 2.0)
			elevator_speed = elevator_speed/2.0;
	}
}
