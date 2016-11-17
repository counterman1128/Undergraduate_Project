package Undergraduate_Project;
import Undergraduate_Project.DoorSensor;
public class Door {
	public boolean doorOpen;
	DoorSensor sensor;
	// Default Constructor
	Door() {
		doorOpen = false;
		sensor = new DoorSensor();
	}
	
	// Accessors
	Boolean getDoorOpen() {
		
		return doorOpen;
	}
	
	// Mutators 
	void setDoorOpen(Boolean state) {
		doorOpen = state;
	}
}
