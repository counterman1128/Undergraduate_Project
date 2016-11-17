package Undergraduate_Project;

public class FloorPanel {
	private Boolean upButtonPressed;
	private Boolean downButtonPressed;
	
	FloorPanel() {
		upButtonPressed = false;
		downButtonPressed = false;
	}
	
	Boolean getUpButtonPressed() {
		return upButtonPressed;
	}
	
	Boolean getDownButtonPressed() {
		return downButtonPressed;
	}
	
	void setUpButtonPressed(Boolean newState) {
		upButtonPressed = newState;
	}
	
	void setDownButtonPressed(Boolean newState) {
		downButtonPressed = newState;
	}
}
