package elevatorProject;

public class Door {
	Boolean doorOpen;
	DoorSensor sensor;
	// Default Constructor
	Door() {
		doorOpen = false;
		sensor = new DoorSensor();
	}

	// Accessors
	Boolean isDoorOpen() {
		return doorOpen;
	}

	Boolean isDoorClosed() {
		return !doorOpen;
	}

	// Mutators
	void setDoorOpen(Boolean state) {
		doorOpen = state;
	}
}
