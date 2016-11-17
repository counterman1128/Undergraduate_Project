package Undergraduate_Project;
import java.util.*;

	public class fireAlarm {
		
	private boolean AlarmOn;
	
	//Accessor 
	public boolean AlarmOn(){
		return AlarmOn;
	}
	//Mutator 
	public void setAlarm (boolean value){
		Alarm = value;
	}
	//Constructor
	public fireAlarm(){
		AlarmOn = false;
	}
}
