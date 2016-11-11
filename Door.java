package elevatorProject;

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
		if(sensor.getData())
		{
			doorOpen = false;
		}
		else
		{
			doorOpen = true;
		}
		return doorOpen;
	}
	
	// Mutators 
	void setDoorOpen(Boolean state) {
		doorOpen = state;
	}
}