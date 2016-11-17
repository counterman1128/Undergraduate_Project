package Undergraduate_Project;
import java.util.*;

public class ElevatorCarPanel {

	////////// Variables //////////

	private boolean emergencyMode;
	private boolean maintenanceMode;
//	private Vector<Integer> destinationFloor = new Vector<>();
	private LinkedList<Integer> destinationFloor;


	////////// Accessors //////////
	public boolean getEmergencyMode() {
		return emergencyMode;
	}

	public boolean getMaintenanceMode() {
		return maintenanceMode;
	}

	////////// Mutators //////////
	public void setEmergencyMode(boolean state){
    	emergencyMode = state;
    }
    public void setMaintenanceMode(boolean state) {
    	maintenanceMode = state;
    }

	////////// Constructor //////////

    ElevatorCarPanel() {
    	emergencyMode = false;
    	maintenanceMode = false;
    	destinationFloor = new LinkedList()<Integer>;
    }


    ////////// Methods //////////

	// This method adds the parameter n to the end of the linked list
	// and returns the first element of the list. If n not a valid input
	// then it returns -1
	public int addFloorNToDistinationFloor(int n) {
		if (n >= 5) {
			return -1;
		} else {
			destinationFloor.push(n);
			return destinationFloor.peekFirst();
		}
	}

	// If a button bas been pressed returs the first number of the first
	// button pressed. If no buttons have been pressed returns -1;
	public int getNextFloor() {
		if (destinationFloor.peek() == null) {
			return -1;
		} else {
			return destinationFloor.pop();
		}
	}


}
