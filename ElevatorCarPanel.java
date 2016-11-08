package elevatorProject;

public class ElevatorCarPanel {
	private int emergencyMode = 0;
	private int maintenanceMode = 0;
    public final int DOOR_OPEN = 1;
    public final int DOOR_CLOSED = 0;
    
    ControlSystem controlSystem = new ControlSystem();
   
    
    public int sentElevatorToFloor(int f){
    	int currentFloor = controlSystem.moveToFloor(f);
    	return currentFloor;
    }
    public int setEmergencyMode(){
    	emergencyMode = 1;
    	return emergencyMode;
    }
    public int setMaintenanceMode() {
    	maintenanceMode = 1;
    	return maintenanceMode;
    }

    
}
