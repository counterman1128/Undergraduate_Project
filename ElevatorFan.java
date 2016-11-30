package Undergraduate_Project;

	public class ElevatorFan {
	
	//Addeed fanOn
	private boolean fanOn = false;

	//Accessor 
	public boolean fanOn(){
		return fanOn;
	}
	//Mutator 
	public void setFan(boolean state){
		fanOn = state;
	}
	//Constructor
	public elevatorFan(){
		fanOn = false;
	}
}
