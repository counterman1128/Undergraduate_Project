package Undergraduate_Project;
import Undergraduate_Project.Display;
import Undergraduate_Project.FloorPanel;
import Undergraduate_Project.Door;


public class Floor {
	public int 		floorNumber;
	private Display 	floorDisplay;
	public FloorPanel 	floorPanel;
	private Door 		floorDoor;

	public double floorPosition;
	public Object panel;
	// Default Constructor, by default the floor is 1
	public Floor(){
		floorNumber 	= 1;
		floorDisplay 	= new Display();
		floorPanel 		= new FloorPanel();
		floorDoor 		= new Door();
	}

	// Sets the floor number to n
	public Floor(int n) {
		floorPosition = n * 10 - 10;
		floorNumber  	= n;
		floorDisplay 	= new Display();
		floorPanel 		= new FloorPanel();
		floorDoor 		= new Door();
		panel = floorPanel.getPanelState();
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
	
	public void changeState(FloorPanelState x){
		/*if(x == 1){
			floorPanel.setUpButtonPressed(true);
		}else if(x == -1){
			floorPanel.setUpButtonPressed(false);
		}else if(x == 0){
			
		}*/
		panel = x;
	}
	
	public int getFloorPanelState(){
		if(floorPanel.getUpButtonPressed())
			return 1;
		else if(floorPanel.getDownButtonPressed())
			return -1;
		return 0;
	}
	
	public Object returnPanelStatus(){
		return panel;	
	}
	
	public void closeFloorDoor()throws InterruptedException{
		floorDoor.setDoorOpen(false);
	}
	public void openFloorDoor()throws InterruptedException{
		floorDoor.setDoorOpen(true);	
	}
	public boolean floorDoorStatus(){
		return floorDoor.getDoorOpen();	
	}
}
