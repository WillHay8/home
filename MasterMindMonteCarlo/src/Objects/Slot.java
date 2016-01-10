package Objects;

import java.util.TreeMap;

public class Slot {
	
	private Colour colour;
	
	private TreeMap<Colour, Slot> nextSlot;
	
	private int wins;
	
	private int rollouts;
	
	private int slotNumber;
	
	private double mcValue;

	public Slot(Colour colour, int slotNumber) {
		this.colour = colour;
		this.slotNumber = slotNumber;
		if(slotNumber<4){
			nextSlot = new TreeMap<Colour, Slot>();
			for(Colour nextColour: Colour.values()){
				nextSlot.put(nextColour, new Slot(nextColour, ++slotNumber));
			}
		}
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public TreeMap<Colour, Slot> getNextSlot() {
		return nextSlot;
	}

	public void setNextSlot(TreeMap<Colour, Slot> nextSlot) {
		this.nextSlot = nextSlot;
	}

	public int getWins() {
		return wins;
	}
	public void incrementWins(){
		wins++;
	}

	public int getRollouts() {
		return rollouts;
	}

	public void incrementRollouts(){
		rollouts++;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	
	public double getMcValue(int totalRollouts){
		if(rollouts==0){
			return Math.sqrt(2.0)*Math.sqrt(Math.log(totalRollouts)/rollouts);
		}
		return 1.0*wins/rollouts+Math.sqrt(2.0)*Math.sqrt(Math.log(totalRollouts)/rollouts);
	}
	
	public double getBestValue(){
		return 1.0*wins/rollouts;
	}
	
}
