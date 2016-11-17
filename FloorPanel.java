package Undergraduate_Project;
import Undergraduate_Project.FloorPanelState;
public class FloorPanel {
	public FloorPanelState state;
	public Object panel = new Object();
	FloorPanel() {
		panel = state.VOID;
	}
	
	public Object getPanelState() {
		return panel;
	}
	
	public void setPanelState(FloorPanelState newState) {
		panel = state.newState;
	}
}
