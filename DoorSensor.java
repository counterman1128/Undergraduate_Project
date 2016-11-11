package elevatorProject;
import java.util.*;

public class DoorSensor {
	
	public boolean isBlocked;
	
	//accessor
	public boolean getData(){
		return isBlocked;
	}
	
	public void setData(){
		Random randomValue = new Random();
		int pick = randomValue.nextInt(2);		
		if (pick == 0)
		{
			isBlocked = true;
		}
		else
		{
			isBlocked = false;
		}
	}
	
	public DoorSensor(){
		setData();
		isBlocked = getData();
	}
	
	public DoorSensor(boolean newData){
		isBlocked = newData;
	}
}