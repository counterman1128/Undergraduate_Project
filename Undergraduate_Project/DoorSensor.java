package Undergraduate_Project;

public class DoorSensor {
	
	private boolean isBlocked;
	
	//accessor
	public boolean isBlocked(){
		return isBlocked;
	}
	
	//Mutator
	public void setBlock(boolean value){
		isBlocked = value;
	}
	
	//default constructor
	public DoorSensor(){
		isBlocked = false;
	}
}
