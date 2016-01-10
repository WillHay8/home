package Objects;

import java.util.TreeMap;

public class Root {
	
	private TreeMap<Colour, Slot> firstSlot;
	
	private int rollouts;

	
	
	public Root() {
		firstSlot = new TreeMap<Colour, Slot>();
		for(Colour colour: Colour.values()){
			firstSlot.put(colour, new Slot(colour, 1));
		}
	}

	public TreeMap<Colour, Slot> getFirstSlot() {
		return firstSlot;
	}

	public void setFirstSlot(TreeMap<Colour, Slot> firstSlot) {
		this.firstSlot = firstSlot;
	}

	public int getRollouts() {
		return rollouts;
	}

	public void incrementRollouts() {
		rollouts++;
	}
	
	
}

