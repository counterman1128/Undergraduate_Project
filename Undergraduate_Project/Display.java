package Undergraduate_Project;

public class Display {
	private int currentFloor;
	private Boolean isGoingUp;
	private Boolean isGoingDown;
	
	// Default Constructor
	Display() {
		currentFloor = 0;
		isGoingUp = false;
		isGoingDown = false;
	}
	
	// Accessors
	int getCurrentFloor() {
		return currentFloor;
	}
	
	Boolean getIsGoingUp() {
		return isGoingUp;
	}
	
	
	Boolean getIsGoingDown() {
		return isGoingDown;
	}
	
	// Mutators 
	void setCurrentFloor(int target) {
		currentFloor = target;
	}
	
	void setIsGoingUp(Boolean state) {
		isGoingUp = state;
	}
	
	void setGoingDown(Boolean state) {
		isGoingDown = state;
	}

}
