package Undergraduate_Project;
import Undergraduate_Project.Door;
import Undergraduate_Project.Display;
//import Undergraduate_Project.ElevatorCarPiston;
import Undergraduate_Project.ElevatorCarPanel;
public class ElevatorCar {
//	private Door 			floorDoor;
	private Door 			elevatorDoor;
	private Display 		elevatorDisplay;
	//private ElevatorCarPiston elevatorPiston;
	private ElevatorCarPanel elevatorCarPanel;
	private int 			currentFloor;
	private int 			destinationFloor;

	public static final int MOVING_UP = 1;
	public static final int NO_DIRECTION = 0;
	public static final int MOVING_DOWN = -1;

	public static final int MOVING = 1;
	public static final int STOPPED = 0;

	public static boolean EMERGENCY_MODE = false;
	public static boolean MAINTENANCE_MODE = false;
	public static boolean PERSON_MODE = true;

	public static final int MAX_LOAD = 3500;

	// Default constructor
	ElevatorCar() {
//		floorDoor 		= new Door();
		elevatorDoor 	= new Door();
		elevatorDisplay = new Display();
		//elevatorPiston 	= new ElevatorCarPiston();
		elevatorCarPanel = new ElevatorCarPanel();
		currentFloor 	= 1;
	}

	// Accessors
//	public Door getFloorDoor() {
//		return floorDoor;
//	}

	public Door getElevatorDoor() {
		return elevatorDoor;
	}
	
	public void openElevatorDoor()throws InterruptedException{
		elevatorDoor.setDoorOpen(true);	
	}
	
	public void closeElevatorDoor()throws InterruptedException{
		elevatorDoor.setDoorOpen(false);	
	}
	
	public Display getElevatorDisplay() {
		return elevatorDisplay;
	}

	/*public ElevatorCarPiston getElevatorCarPiston() {
		return elevatorPiston;
	}*/

	public ElevatorCarPanel getElevatorCarPanel() {
		return elevatorCarPanel;
	}

	public int currentFloor() {
		return currentFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}



	// Mutators
	public static void setEmergencyMode(Boolean state){
		EMERGENCY_MODE = state;
	}

	public static void setMaintenanceMode(Boolean state) {
		MAINTENANCE_MODE = state;
	}

	public static void setPersonMode(Boolean state) {
		PERSON_MODE = state;
	}

	public void setDetinationFloor(int n) {
		destinationFloor = n;
	}


//	private int doorState;
//	private int motionState;
//	private int motionDirection;

}
