package elevatorProject;
import java.util.*;

public class Elevator {
	private Floor [] floor;
	private ElevatorCar elevatorCar;
	private ControlSystem controlSystem;
	
	// Constructors
	Elevator() {
		// Creates 2 floors
		for (int i = 0; i < 2; i++) {
			floor[i] = new Floor(i);
		}
		elevatorCar 	= new ElevatorCar(); 
		controlSystem 	= new ControlSystem();
	}
	
	Elevator(int n) {
		// Creates n number of floors
		for (int i = 0; i < n; i++){
			floor[i] = new Floor(i);
		}
		
		elevatorCar 	= new ElevatorCar();
		controlSystem 	= new ControlSystem();
	}
}
