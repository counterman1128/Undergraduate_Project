package Undergraduate_Project;

public class EmergencyBreaks{
	
	private boolean breaksOn;
	
	//default constructor
	EmergencyBreaks(){
		breaksOn = false;
	}
	
	//accessor
	public boolean breaksOn(){
		return breaksOn;
	}
	
	//mutator
	public void setBreaks(boolean value){
		breaksOn = value;	
	}


}