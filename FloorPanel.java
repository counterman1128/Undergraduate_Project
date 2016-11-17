package Undergraduate_Project;
import Undergraduate_Project.FloorPanelState;

public class FloorPanel {
	private Boolean upButtonPressed;
	private Boolean downButtonPressed;
	public FloorPanelState state;
	public Object panel = new Object();
	FloorPanel() {
		upButtonPressed = false;
		downButtonPressed = false;
		panel=state.VOID;
	}
	
	Boolean getUpButtonPressed() {
		return upButtonPressed;
	}
	
	Boolean getDownButtonPressed() {
		return downButtonPressed;
	}
	
	void setUpButtonPressed(Boolean newState) {
		upButtonPressed = newState;
		downButtonPressed = !newState;
		if(newState)
			panel = state.UP;
		else
			panel = state.DOWN;
	}
	
	void setDownButtonPressed(Boolean newState) {
		downButtonPressed = newState;
		upButtonPressed = !newState;
		if(newState)
			panel = state.DOWN;
		else
			panel = state.UP;
	}
	
	public Object getPanelState(){
		return panel;	
	}
}
