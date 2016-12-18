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
import Undergraduate_Project.VUI;
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
	//public Piston object;
	public FloorPanelState state;
	
	//Floor Objects
	public Floor[] floor = new Floor[5];
	public Floor past;
	
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
	public VUI v = new VUI();
 	
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
		weight.setWeight(0);
 	}
	
	/* Used to run the checking of all the states of the elevator
	 * 
	 *  
	 */
	public void run() throws InterruptedException{
 		this.SystemInputCheck();
 		
 		// checks door obstruction input
 		while(ip.getDoorObstruction()){
 			obstruct_door();
 			if(cp.getDoorStatus()) {
 				cp.doorOpen();
 				fp.openDoor(piston.getCurrentFloor());
 			}
 			else {
 				cp.doorOpenGif();
 				fp.openDoorGif(piston.getCurrentFloor());
 			}
 			v.play_clip(8);
 		}
 		
 		// checks weight before moving
 		if(ip.getWeight() >= 3500){
 			while(ip.getWeight() >= 3500) {
 				this.checkWeight();
 			}
 		}
 		else {
 			weight.setWeight(0);
 			fp.closeDoor(piston.getCurrentFloor());
 		}
 		
 		// checks speed and adjusts before moving
 		if(ip.getiSpeed()){
 			this.overwrite_speed();
 		}
 		
 		// changes the position
 		if(ip.getiPos()) {
 			this.overwrite_position();
 			ip.setiPos(false);
 		}
 		// for maintenance mode buttons on left side
 		maintenance_mode();
 		
 		fp.setDisplayTo(piston.c_display());
 		cp.setDisplayTo(piston.c_display());
 		if(queue.size() != 0){
 			fp.setFlUpOff(queue.peek().getFloorNumber());
 			fp.setFlDownOff(queue.peek().getFloorNumber());
 		}
 	
 		//Need to add piston state check to accurately stop at floors. Priority Queue doesnt seem to sort
 		if(car_panel.size() != 0 && piston.getCurrentFloor() == piston.getDestinationFloor()){
 			previous = car_panel.get(0);
 			piston.setDestinationFloor(car_panel.get(0));
 			if(piston.getCurrentPosition() == piston.getFloorPosition()){
 				cp.flOff(piston.getDestinationFloor()-1);
 				fp.setFlUpOff(piston.getDestinationFloor());
	 			fp.setFlDownOff(piston.getDestinationFloor());
	 			fp.setDisplayTo(piston.getCurrentFloor());
	 	 		cp.setDisplayTo(piston.getCurrentFloor());
	 			v.play_clip(piston.getDestinationFloor());
 				cp.doorOpenGif();
 				fp.openDoorGif(piston.getDestinationFloor());
 				Thread.sleep(5000);
 				cp.doorCloseGif();
 				fp.closeDoorGif(piston.getDestinationFloor());
 				
 				car_panel.remove(0);
 				car_panel.trimToSize();
 				 			
 			}
 			
 		}else if(queue.size() != 0 && piston.getCurrentFloor() == piston.getDestinationFloor()){
 			previous = queue.peek().getFloorNumber();
 			past = queue.peek();
 			fp.setFlUpOff(piston.getDestinationFloor());
 			fp.setFlDownOff(piston.getDestinationFloor());
 			piston.setDestinationFloor(queue.peek().getFloorNumber());
 			if(piston.getCurrentFloor() == piston.getDestinationFloor()) {
 				queue.remove(queue.peek());
 				v.play_clip(piston.getDestinationFloor());
 				cp.doorOpenGif();
 				fp.openDoorGif(piston.getDestinationFloor());
 				Thread.sleep(5000);
 				cp.doorCloseGif();
 				fp.closeDoorGif(piston.getDestinationFloor());
 			}
 		}else if(car_panel.size() !=0){
 			if(car_panel.get(0) == piston.getCurrentFloor() /*&& piston.getCurrentFloor() != piston.getDestinationFloor()*/){
 				piston.setDestinationFloor(car_panel.get(0));
 				if(piston.getCurrentPosition() == piston.getFloorPosition()){
 					cp.flOff(piston.getDestinationFloor()-1);
 					v.play_clip(piston.getDestinationFloor());
 	 				cp.doorOpenGif();
 	 				fp.openDoorGif(piston.getDestinationFloor());
 	 				Thread.sleep(5000);
 	 				cp.doorCloseGif();
 	 				fp.closeDoorGif(piston.getDestinationFloor());
 					car_panel.remove(0);
 	 				car_panel.trimToSize();
 	 				piston.setDestinationFloor(previous);
 				}
 			}
 		
 		}else if(queue.size() != 0 && queue.peek() != past){
 			if(queue.peek().getFloorNumber() == piston.getCurrentFloor() && piston.getCurrentFloor() != piston.getDestinationFloor()){
 				piston.setDestinationFloor(queue.peek().getFloorNumber());
 				
 				if(piston.getDestinationFloor() == piston.getCurrentFloor()){
 					cp.flOff(piston.getDestinationFloor()-1);
 					queue.remove(queue.peek());
 					v.play_clip(piston.getDestinationFloor());
 	 				cp.doorOpenGif();
 	 				fp.openDoorGif(piston.getDestinationFloor());
 	 				Thread.sleep(5000);
 	 				cp.doorCloseGif();
 	 				fp.closeDoorGif(piston.getDestinationFloor());
 					//Thread.sleep(5000);
 					//fp.panel_off(int f);
 					//this.door_function();
 					piston.setDestinationFloor(previous);
 				}
 		}
 	}
 		piston.piston_main();
		 // Usually elevator reports position e.g. 2,4,8,10,12 ...
		// This causes the elevator position to be updated 5 times per up/down
		// Code here updates the position once per up/down so image looks smoother
 		if (this.getElevatorPosition() == 6.0) {
          pp.piston_rep(this.getElevatorPosition(), piston.getPistonState());
          cp.doorCloseOff();
          cp.doorOpenOff();
 		} else if (this.getElevatorPosition() == 16.0) {
          pp.piston_rep(this.getElevatorPosition(), piston.getPistonState());
          cp.doorCloseOff();
          cp.doorOpenOff();
 		}  else if (this.getElevatorPosition() == 26.0) {
          pp.piston_rep(this.getElevatorPosition(), piston.getPistonState());
          cp.doorCloseOff();
          cp.doorOpenOff();
 		}  else if (this.getElevatorPosition() == 36.0) {
          pp.piston_rep(this.getElevatorPosition(), piston.getPistonState());
          cp.doorCloseOff();
          cp.doorOpenOff();
 		} 
 		
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
		if(floor_calls[0] == true && !queue.contains(floor[0])){
			Floor c = floor[0];
			//c.changeState(FloorPanelState.UP);
			queue.add(c);
			floor_calls[0] = false;
		}
		//Floor 2 up call
		if(floor_calls[1] == true && !queue.contains(floor[1])){
			Floor c = floor[1];
			//c.changeState(FloorPanelState.UP);
			queue.add(c);
			floor_calls[1] = false;
		}
		//Floor 2 down call
		if(floor_calls[2] == true && !queue.contains(floor[1])){
			Floor c = floor[1];
			//c.changeState(FloorPanelState.DOWN);
			queue.add(c);
			floor_calls[2] = false;
		}
		//Floor 3 up call
		if(floor_calls[3] == true && !queue.contains(floor[2])){
			Floor c = floor[2];
			//c.changeState(FloorPanelState.UP);
			queue.add(c);
			floor_calls[3] = false;
		}
		//Floor 3 down call
		if(floor_calls[4] == true && !queue.contains(floor[2])){
			Floor c = floor[2];
			//c.changeState(FloorPanelState.DOWN);
			queue.add(c);
			floor_calls[4] = false;
		}
		//Floor 4 up call
		if(floor_calls[5] == true && !queue.contains(floor[3])){
			Floor c = floor[3];
			//c.changeState(FloorPanelState.UP);
			queue.add(c);
			floor_calls[5] = false;
		}
		//Floor 4 down call
		if(floor_calls[6] == true && !queue.contains(floor[3])){
			Floor c = floor[3];
			//c.changeState(FloorPanelState.DOWN);
			queue.add(c);
			floor_calls[6] = false;
		}
		//Floor 5 down call
		if(floor_calls[7] == true && !queue.contains(floor[4])){
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
		if(alarm.AlarmOn() == true || ip.getFire() == true){
			cp.startAlarmMode();
			fp.openDoor(piston.getCurrentFloor());
			v.play_clip(6);
			this.moveToNearestFloor();
			floor[piston.getCurrentFloor()].openFloorDoor();	
		}
		else {
			cp.endAlarmMode();
		}
	}
	
	public void checkWeight() throws InterruptedException{
		if(weight.overWeight() == true){}
			if(cp.getDoorStatus() == false) {
				cp.doorOpenGif();
				fp.openDoorGif(piston.getCurrentFloor());
			}
			else {
				cp.doorOpen();
				fp.openDoor(piston.getCurrentFloor());
			}
			v.play_clip(7);
			Thread.sleep(5000);
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
	
	public void overwrite_speed() {
		piston.elevator_speed = ip.getSpeed();
		ip.setiSpeed(false);
	}
	public void overwrite_position(){
		piston.currentPosition = ip.getPos();
		if(piston.currentPosition >= 0 && piston.currentPosition <= 5){
			queue.add(floor[0]);
		}
		else if(piston.currentPosition > 5 && piston.currentPosition <= 15) {
			queue.add(floor[1]);
		}
		else if(piston.currentPosition > 15 && piston.currentPosition <= 25) {
			queue.add(floor[2]);
		}
		else if(piston.currentPosition > 25 && piston.currentPosition <= 35) {
			queue.add(floor[3]);
		}
		else if(piston.currentPosition > 35) {
			queue.add(floor[4]);
		}
		ip.setiPos(false);
	}
	public void maintenance_mode() {
		if(ip.getMaintenanceMode()){
			cp.maintTurn();
			elevatorCar.setMaintenanceMode(true);
			piston.setDestinationFloor(0);
		}
		else {
			cp.maintNorm();
			elevatorCar.setMaintenanceMode(false);
		}
	}
	public void obstruct_door(){
		if(ip.getMaintenanceMode()){
			floor[piston.getCurrentFloor()].getFloorDoor().setDoorSensor(true);
		}else{
			floor[piston.getCurrentFloor()].getFloorDoor().setDoorSensor(false);
		}
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

