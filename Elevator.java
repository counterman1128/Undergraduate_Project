package Undergraduate_Project;
import Undergraduate_Project.ElevatorCar;
import Undergraduate_Project.Floor;
import java.util.*;

public class Elevator {
	////////// Variables //////////

	private int numberOfFloors;
	private Floor [] floor;
	private ElevatorCar elevatorCar;
	//private ElevatorSimulationRun controlSystem;

	static final boolean DOOR_OPEN = true;
	static final boolean DOOR_CLOSED = false;
	static final int FLOORS = 5;



	////////// Constructor //////////

	// Default Constructor, by default has two floors
	// Creates 2 floors
	Elevator() {
		for (int i = 0; i < FLOORS; i++) {
			floor[i] = new Floor(i);
		}
		numberOfFloors = FLOORS;
		elevatorCar 	= new ElevatorCar();
		//controlSystem 	= new ElevatorSimulationRun();
	}

	// Constructor creates elevator with n floors.
	// Creates n number of floors

	Elevator(int n) {
		for (int i = 0; i < n; i++){
			floor[i] = new Floor(i);
		}
		numberOfFloors  = n;
		elevatorCar 	= new ElevatorCar();
		//controlSystem 	= new ElevatorSimulationRun();
	}


	////////// Methods //////////

	// Checks if a floor has upButton pressed, if a button has been pressed
	// returns the floor where the button "UP" was pressed, otherwise it
	// returns the current floor where the elevator is
	int checkAllFloorsForUpButton() {
		// By default the elevators returns the current floor where
		// piston is located at
		int calledUpFromFloor = elevatorCar.getElevatorCarPiston().getCurrentFloor();
		// Loops through all the floors
		for (int i = 0; i < numberOfFloors; i++){
			if (floor[i].getFloorDisplay().getIsGoingUp()){
				calledUpFromFloor = i;
			}
		}
		return calledUpFromFloor;
	}

	// Checks if a floor has upDown pressed, if a button has been pressed
	// returns the floor where the button "DOWN" was pressed, otherwise it
	// returns the current floor where the elevator is
	int checkAllFloorsForDownButton() {
		// By default the elevators returns the current floor where
		// piston is located at
		int calledDownFromFloor = elevatorCar.getElevatorCarPiston().getCurrentFloor();
		// Loops through all the floors
		for (int i = 0; i < numberOfFloors; i++) {
			if (floor[i].getFloorDisplay().getIsGoingDown()){
				calledDownFromFloor = i;
				return calledDownFromFloor;
			}
		}
		return calledDownFromFloor;
	}

	// Checks if a floor button inside on the elevator has been pressed,
	// if button has been pressed returns the floor number, otherwise returns
	// -1
	int checkFloorFromElevatorCarPanel() {
		if (elevatorCar.getElevatorCarPanel().getNextFloor() == -1) {
			return -1; 						// No button pressed
		} else {
			return elevatorCar.getElevatorCarPanel().getNextFloor();
		}
	}

	// Check if door at floor n is open. If door open returns true
	// otherwise returns false
	boolean isFloorDoorOpen(int n) {
		return floor[n].getFloorDoor().isDoorOpen();
	}

	// Opens the door at floor n. If input n > numberOfFloors returns false,
	// otherwise it opens door at floor n and returns true, if door already
	// open doesn't do anything and returns true
	boolean openFloorDoor(int n) {
		if (n >= numberOfFloors) {
			return false;
		}
		else if (floor[n-1].getFloorDoor().isDoorClosed()) {
			floor[n-1].getFloorDoor().setDoorOpen(DOOR_OPEN);
			return true;
		}
		return true;
	}

	// Closes the door at floor n. If input n > numberOfFloors returns false,
	// otherwise it closes door at floor n and return true, if door already
	// closed doesn't do anything and returns true;
	boolean closeFloorDoor(int n) {
		if (n >= numberOfFloors){
			return false;
		}
		else if (floor[n].getFloorDoor().isDoorOpen()) {
			floor[n].getFloorDoor().setDoorOpen(DOOR_CLOSED);
			return true;
		}
		return true;
	}

	// Returns the state of elevator door. If door open returns true
	// otherwise returns false
	boolean isElevatorCarDoorOpen() {
		return elevatorCar.getElevatorDoor().isDoorOpen();
	}

	// Opens the door of the elevator car
	void openElevatorCarDoor() {
		elevatorCar.getElevatorDoor().setDoorOpen(DOOR_OPEN);
	}

	// Closes the door of the elevator car
	void closeElevatorCarDoor() {
		elevatorCar.getElevatorDoor().setDoorOpen(DOOR_CLOSED);
	}




//	Elevetor.Floor[2].FloorPanel.setUpButtonPressed(true);
//	Elevartor.Floor[2].setUpButtonPressed(true);
}
