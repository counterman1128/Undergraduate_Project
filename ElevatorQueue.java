//Comparator Class
public class ElevatorQueue implements Comparator<Floor>{//May have to add function to check postion of floors compared to each other
	@Override
	public int compare(Floor obj1, Floor obj2){
		if(piston.getPistonState() == object.MOVING_UP){
			if(obj1.getFloorPanelState() > obj2.getFloorPanelState())
				return 1;
			if(obj1.getFloorPanelState() < obj2.getFloorPanelState())  
				return -1;
		}
		if(piston.getPistonState() == object.MOVING_DOWN){
			if(obj1.getFloorPanelState() < obj2.getFloorPanelState())
				return 1;
			if(obj1.getFloorPanelState() > obj2.getFloorPanelState())
				return -1;
		}
		if(piston.getPistonState() == object.STATIONARY)
			return 1;
		return 0;
	}
}