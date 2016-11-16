package elevatorProject;

public class Floor {
	private int 		floorNumber;
	private Display 	floorDisplay;
	private FloorPanel 	floorPanel;
	private Door 		floorDoor;


	// Default Constructor, by default the floor is 1
	Floor(){
		floorNumber 	= 1;
		floorDisplay 	= new Display();
		floorPanel 		= new FloorPanel();
		floorDoor 		= new Door();
	}

	// Sets the floor number to n
	Floor(int n) {
		floorNumber  	= n;
		floorDisplay 	= new Display();
		floorPanel 		= new FloorPanel();
		floorDoor 		= new Door();
	}

	// Accessors
	public int getFloorNumber() {
		return floorNumber;
	}

	public Display getFloorDisplay() {
		return floorDisplay;
	}

	public FloorPanel getFloorPanel() {
		return floorPanel;
	}

	public Door getFloorDoor() {
		return floorDoor;
	}
	
	public int getFloorPanelState(){
		if(floorPanel.upButtonPressed())
			return 1;
		else if(floorPanel.downButtonPressed())
			return -1;
		return 0;
	}


}
