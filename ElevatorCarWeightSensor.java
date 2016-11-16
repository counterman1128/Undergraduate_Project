package elevatorProject;

public class ElevatorCarWeightSensor{
	
	//Contains all individual weights on the elevator car
	private ArrayList<Double> weightArray = new ArrayList<Double>();
	
	//Summation of all weights on elevator
	public double totalWeight = 0;
	
	//Maximum weight allowed
	public final double maxWeight = 3500.0;
	
	//Default Constructor
	public ElevatorCarWeightSensor(){}
	
	//Sums all weights on the elevator
	public double getTotalWeight(){
		for(double x: weightArray){
			totalWeight = totalWeight + x;
		}
		return totalWeight;
	}
	
	//Adds unique weight to a list
	public void addWeight(double m){
		weightArray.add(m);
	}
	
	//Removes a unique weight from a list
	public void removeWeight(double m){
		weightArray.remove(m);
	}
	
	//Clears all elements from the array
	public void clearWeightArray(){
		weightArray.clear();
	}
	
	//Mutator for totalWeight
	public void setWeight(double m){
		totalWeight = m;
	}
	
	//Prints a list of all weights on the elevator
	public void getListOfWeights(){
		System.out.print("List of weights: ");
		for(double x: weightArray){
			System.out.print(x + " ");
		}
	}
	
	public boolean overWeight(){
		if(this.getTotalWeight() > maxWeight)
			return true;
		else
			return false;
	}
	
	public boolean setSensorValue(boolean value){
		return value;
	}
}