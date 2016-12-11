package Undergraduate_Project;
/* Class Variables changes
private final int NUMBER_OF_FLOORS = 5;
private final int INITIAL_ELEVATOR_FLOOR = 1;
private static boolean DOOR_OPEN;
public Piston object;
public FloorPanelState state;
public Floor []floor;
public EmergencyBreaks brake = new EmergencyBreaks();
public Comparator<Floor> comparator = new ElevatorQueue();
public PriorityQueue<Floor> queue = new PriorityQueue<Floor>(5, comparator);
public ElevatorCar elevatorCar = new ElevatorCar();
public ElevatorCarPiston piston = new ElevatorCarPiston(INITIAL_ELEVATOR_FLOOR, NUMBER_OF_FLOORS);

Class Methods
public ControlSystem();
public void checkForFloorInput();
public void removeFloorFromQueue(Floor obj);
public void clearQueue();
public int moveToFloor(int targetFloor);
public double getElevatorSpeed();
public void speedSafety();
public void EM_Brake_Procedure();
public void FireAlarmCheck();
public void door_function();
public void moveToNearestFloor();
public void SystemInputCheck();

Sub Class
	public class ElevatorQueue extends ControlSystem implements Comparator<Floor>{}
*/
import Undergraduate_Project.Floor;
import Undergraduate_Project.FloorPanel;
import Undergraduate_Project.Piston;
import Undergraduate_Project.FloorPanelState;
import Undergraduate_Project.EmergencyBreaks;
import Undergraduate_Project.Door;
import Undergraduate_Project.elevatorLight;
import Undergraduate_Project.ElevatorFan;
import Undergraduate_Project.fireAlarm;
import Undergraduate_Project.ElevatorCarWeightSensor;
import Undergraduate_Project.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Comparable;
import java.util.PriorityQueue;
//import java.util.Queue;
public class ControlSystem {
	private final int NUMBER_OF_FLOORS = 5;
	private final int INITIAL_ELEVATOR_FLOOR = 1;
	private static boolean DOOR_OPEN;
	
	//Used for comparator class
	//public enum Piston{MOVING_UP, STATIONARY, MOVING_DOWN}
//	public Piston object;
	public FloorPanelState state;
	
	//Floor Objects
	public Floor[] floor = new Floor[5];
	
	//EM Brake Object
	public EmergencyBreaks brake = new EmergencyBreaks();
	
	//Queue
	public Comparator<Floor> comparable = new ElevatorQueue();
	public PriorityQueue<Floor> queue = new PriorityQueue<Floor>(10,comparable);
	public ArrayList<Integer> car_panel = new ArrayList<Integer>(5);
	public int previous = 0;
	
	public ElevatorCarWeightSensor weight = new ElevatorCarWeightSensor();
	public fireAlarm alarm = new fireAlarm();
	public ElevatorCar elevatorCar = new ElevatorCar();
	public ElevatorCarPiston piston = new ElevatorCarPiston(INITIAL_ELEVATOR_FLOOR, NUMBER_OF_FLOORS);
 	
	ControlSystem(){
		for(int i = 0; i < NUMBER_OF_FLOORS; i++)
			floor[i] = new Floor(i);	
	}
 	
	PistonPanelGUI pp; 
	FloorPanelGUI fp;
	CarPanelGUI cp;
	InputPanelGUI ip;

	
	
	public ControlSystem(PistonPanelGUI pp, FloorPanelGUI fp,CarPanelGUI cp,InputPanelGUI ip) throws InterruptedException {
 		this.pp = pp;
 		this.fp = fp;
 		this.cp = cp;
 		this.ip = ip;
		for(int i = 0; i < NUMBER_OF_FLOORS; i++)
			floor[i] = new Floor(i);
		/*while (true) {
			Thread.sleep(50);
			this.run();
		}*/
 	}
	
	/* Used to run the checking of all the states of the elevator
	 * 
	 *  
	 */
	public void run() throws InterruptedException{//Cant seem to clear element from the queue
 		this.SystemInputCheck();
 	
 		//Need to add piston state check to accurately stop at floors. Priority Queue doesnt seem to sort
 		if(car_panel.size() != 0 && piston.getCurrentFloor() == piston.getDestinationFloor()){
 			previous = car_panel.get(0);
 			piston.setDestinationFloor(car_panel.get(0));
 			if(piston.getCurrentFloor() == piston.getDestinationFloor()){
 				cp.flOff(piston.getDestinationFloor()-1);
 				car_panel.remove(0);
 				car_panel.trimToSize();
 			}
 		}else if(queue.size() != 0 && piston.getCurrentFloor() == piston.getDestinationFloor()){
 			previous = queue.peek().getFloorNumber();
 			piston.setDestinationFloor(queue.peek().getFloorNumber());
 			System.out.println("Removed obj: "+queue.peek().getFloorNumber()+" "+queue.remove(queue.peek()));
 			if(piston.getCurrentFloor() == piston.getDestinationFloor())
 				queue.remove(queue.peek());
 		}else if(car_panel.size() !=0){
 			if(car_panel.get(0) == piston.getCurrentFloor() /*&& piston.getCurrentFloor() != piston.getDestinationFloor()*/){
 				piston.setDestinationFloor(car_panel.get(0));
 				if(piston.getDestinationFloor() == piston.getCurrentFloor()){
 					cp.flOff(piston.getDestinationFloor()-1);
 					car_panel.remove(0);
 	 				car_panel.trimToSize();
 	 				piston.setDestinationFloor(previous);
 				}
 			}
 		
 		}else if(queue.size() != 0){
 			if(queue.peek().getFloorNumber() == piston.getCurrentFloor() && piston.getCurrentFloor() != piston.getDestinationFloor()){
 				piston.setDestinationFloor(queue.peek().getFloorNumber());
 				System.out.println("Floor obj: "+queue.peek().getFloorNumber());
 				System.out.println("Piston Floor: "+ piston.getCurrentFloor());
 				
 				if(piston.getDestinationFloor() == piston.getCurrentFloor()){
 					cp.flOff(piston.getDestinationFloor()-1);
 					queue.remove(queue.peek());
 					//Thread.sleep(5000);
 					//fp.panel_off(int f);
 					//this.door_function();
 					piston.setDestinationFloor(previous);
 				}
 		}
 		
 	}
 		piston.piston_main();
 		//System.out.println("Check1");
 		//if(piston.getCurrentFloor() == piston.getDestinationFloor()){
 			//System.out.println("Check2");
					//cp.flOff(piston.getDestinationFloor()-1);
					//this.door_function();
		//}
 	}
 	
	
 	
 	
 	
	/*
	 * Develop function to receive calls from Floor Panels. Then push the floor
	 * object to the queue.
	 *	-> queue.add(<floor object>) //Adds object to Queue
	 *	-> queue.remove(<floor object>) //Removes object from Queue
	 *	-> queue.clear() //Clears Queue
	 * 
	 * 	Always add the next highest or lowest floor first. 
	 */
	public void checkForFloorInput(){
		boolean floor_buttons[] = new boolean[5];
		floor_buttons = cp.getButtonsPressed();
		
		for(int i = 0; i < NUMBER_OF_FLOORS; i++){
			if(floor_buttons[i] == true){
				//queue.add(floor[i]);
				car_panel.add(floor[i].getFloorNumber());
				
				floor_buttons[i]=false;
				cp.flOn(i);
			}
			//System.out.println(car_panel.get(i));
		}
		
		boolean floor_calls[] = new boolean[8]; 
		floor_calls = fp.getFloorStatus();
		
			
		//Floor 1 Up call
		if(floor_calls[0] == true){
			Floor c = floor[0];
			//c.changeState(FloorPanelState.UP);
			queue.add(c);
			floor_calls[0] = false;
		}
		//Floor 2 up call
		if(floor_calls[1] == true){
			Floor c = floor[1];
			//c.changeState(FloorPanelState.UP);
			queue.add(c);
			floor_calls[1] = false;
		}
		//Floor 2 down call
		if(floor_calls[2] == true){
			Floor c = floor[1];
			//c.changeState(FloorPanelState.DOWN);
			queue.add(c);
			floor_calls[2] = false;
		}
		//Floor 3 up call
		if(floor_calls[3] == true){
			Floor c = floor[2];
			//c.changeState(FloorPanelState.UP);
			queue.add(c);
			floor_calls[3] = false;
		}
		//Floor 3 down call
		if(floor_calls[4] == true){
			Floor c = floor[2];
			//c.changeState(FloorPanelState.DOWN);
			queue.add(c);
			floor_calls[4] = false;
		}
		//Floor 4 up call
		if(floor_calls[5] == true){
			Floor c = floor[3];
			//c.changeState(FloorPanelState.UP);
			queue.add(c);
			floor_calls[5] = false;
		}
		//Floor 4 down call
		if(floor_calls[6] == true){
			Floor c = floor[3];
			//c.changeState(FloorPanelState.DOWN);
			queue.add(c);
			floor_calls[6] = false;
		}
		//Floor 5 down call
		if(floor_calls[7] == true){
			Floor c = floor[4];
			//c.changeState(FloorPanelState.DOWN);
			queue.add(c);
			floor_calls[7] = false;
		}
			
	}
	
	public void CarPanelInput(){
		if(elevatorCar.getPanelCall() != -1)
			car_panel.add(elevatorCar.getPanelCall());
	}
	
	public PriorityQueue<Floor> return_queue(){
		return queue;	
	}
	
	public void removeFloorFromQueue(Floor obj){
		queue.remove(obj);
	}
	
	public void clearQueue(){
		queue.clear();	
	}
	
	int moveToFloor(int targetFloor) {
		int currentFloor = piston.movePistonToFloor(targetFloor);
		return currentFloor;
	}
	
	public double getElevatorSpeed(){
		return piston.getSpeed();
	}
	
	public double getElevatorPosition(){
		return piston.getCurrentPosition();	
	}
	
	public void speedSafety(){
		if(piston.getSpeed() > 2.0)
			this.EM_Brake_Procedure();
	}
	
	public void EM_Brake_Procedure(){
		brake.setBreaks(true);
		while(piston.getSpeed() > 0.0){
			piston.deacceleration();
			if(piston.getSpeed() <= 0.0)
				piston.setSpeed(0.0);
		}
		//Implement function to move elevator to closest floor
		brake.setBreaks(false);
		piston.resetSpeed();
	}
	
	public void FireAlarmCheck()throws InterruptedException{
		if(alarm.AlarmOn() == true){
			this.moveToNearestFloor();
			floor[piston.getCurrentFloor()].openFloorDoor();	
		}
	}
	
	public void checkWeight(){
		if(weight.overWeight() == true){}
			//Implement Safety Function here
	}
	
	//Opening Floor Door and elevator Door when destination is reached
	public void door_function()throws InterruptedException{
		//If elevator is still moving deny call to open door
		if(piston.getPistonState() != Piston.STATIONARY){
		
		//Check floor sensor. If piston position equals floor position then open floor door and elevator door
		}else if(piston.getCurrentPosition() == piston.getDestinationFloor()){
			elevatorCar.openElevatorDoor();
			floor[piston.getCurrentFloor()].openFloorDoor();
			//this.removeFloorFromQueue(floor[piston.getCurrentFloor()]);
			floor[piston.getCurrentFloor()].openFloorDoor();
		}
	}
	
	//Used for Emergency Functions
	public void moveToNearestFloor(){
		if(piston.getCurrentPosition() < 5.0)
			piston.movePistonToFloor(1);
		if(piston.getCurrentPosition() < 15.0)
			piston.movePistonToFloor(2);
		if(piston.getCurrentPosition() < 25.0)
			piston.movePistonToFloor(3);
		if(piston.getCurrentPosition() < 35.0)
			piston.movePistonToFloor(4);
		else
			piston.movePistonToFloor(5);
	}
	
	public void SystemInputCheck()throws InterruptedException{
		this.checkForFloorInput();
		this.speedSafety();
		this.FireAlarmCheck();
	}
	
	public class ElevatorQueue extends Floor implements Comparator<Floor> {
		//May have to add function to check postion of floors compared to each other
		public boolean equals(Object obj){
			System.out.println("check");
			if(obj instanceof Floor){
				Floor c = (Floor) obj;
				//for(int i = 0; i<5;i++){
					//if(obj.floorPosition == floor[i].floorPosition && floor[i].returnPanelStatus() == obj.returnPanelStatus()){
						return getFloorPanelState() == c.getFloorPanelState() && c.getFloorNumber() == getFloorNumber();
					//}
				//}
			}
			
			return false;
		}
		
		public int compare(Floor obj1, Floor obj2){
			if(piston.getPistonState() == Piston.MOVING_UP){
				if(obj1.getFloorPanelState() > obj2.getFloorPanelState())
					return 1; //1
				if(obj1.getFloorPanelState() < obj2.getFloorPanelState())  
					return -1; //-1
				if(obj1.floorPosition < obj2.floorPosition && obj1.returnPanelStatus() == FloorPanelState.UP && obj1.floorPosition > piston.getCurrentPosition())
					return 1; //1
				else if(obj2.returnPanelStatus() == FloorPanelState.UP && obj2.floorPosition > piston.getCurrentPosition())
					return -1; //-1
			
			}
			if(piston.getPistonState() == Piston.MOVING_DOWN){
				if(obj1.getFloorPanelState() < obj2.getFloorPanelState())
					return 1;//1
				if(obj1.getFloorPanelState() > obj2.getFloorPanelState())
					return -1;//-1
				if(obj1.floorPosition > obj2.floorPosition && obj1.returnPanelStatus() == FloorPanelState.DOWN && obj1.floorPosition < piston.getCurrentPosition())
					return 1;//1
				else if(obj2.returnPanelStatus() == FloorPanelState.DOWN && obj2.floorPosition < piston.getCurrentPosition())
					return -1;//-1
			}
			if(piston.getPistonState() == Piston.STATIONARY)
				return 1;
			return 0;
		}
		
		public int compareTo(Object obj2){
			if(obj2 instanceof Floor){
				Floor c = (Floor) obj2;
				if(piston.getPistonState() == Piston.MOVING_UP){
					if(this.getFloorPanelState() > c.getFloorPanelState())
						return 1; //1
					if(this.getFloorPanelState() < c.getFloorPanelState())  
						return -1; //-1
					if(this.floorPosition < c.floorPosition && this.returnPanelStatus() == FloorPanelState.UP && this.floorPosition > piston.getCurrentPosition())
						return 1; //1
					else if(c.returnPanelStatus() == FloorPanelState.UP && c.floorPosition > piston.getCurrentPosition())
						return -1; //-1
				
				}
				if(piston.getPistonState() == Piston.MOVING_DOWN){
					if(this.getFloorPanelState() < c.getFloorPanelState())
						return 1;//1
					if(this.getFloorPanelState() > c.getFloorPanelState())
						return -1;//-1
					if(this.floorPosition > c.floorPosition && this.returnPanelStatus() == FloorPanelState.DOWN && this.floorPosition < piston.getCurrentPosition())
						return 1;//1
					else if(c.returnPanelStatus() == FloorPanelState.DOWN && c.floorPosition < piston.getCurrentPosition())
						return -1;//-1
				}
				if(piston.getPistonState() == Piston.STATIONARY)
					return 1;
				return 0;
			}
			return 0;
		}
	}

}

