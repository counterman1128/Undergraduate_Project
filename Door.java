package Undergraduate_Project;
import Undergraduate_Project.DoorSensor;
public class Door {
	public boolean doorOpen;
	public boolean door_sensor;
	// Default Constructor
	Door() {
		doorOpen = false;
		door_sensor = false;
	}
	
	// Accessors
	Boolean getDoorOpen() {
		
		return doorOpen;
	}
	public void setDoorSensor(boolean x){
		door_sensor = x;
	}
	public boolean getDoorSensor() {
		return door_sensor;
	}
	// Mutators 
	void setDoorOpen(Boolean state)throws InterruptedException {
		Thread.sleep(2500);
		doorOpen = state;
	}
}
