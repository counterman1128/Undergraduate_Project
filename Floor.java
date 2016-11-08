package elevatorProject;

public class Floor {
	private int 		floorNumber;
	private Display 	floorDisplay;
	private FloorPanel 	floorPanel;
	private Door 		floorDoor;
	
	
	// Constructors
	Floor(){
		floorNumber 	= 1;
		floorDisplay 	= new Display();
		floorPanel 		= new FloorPanel();
		floorDoor 		= new Door();
	}
	
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
	
	
}
