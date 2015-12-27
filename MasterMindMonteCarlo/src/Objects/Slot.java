package Objects;

import java.util.HashMap;

public class Slot {
	
	private Colour colour;
	
	private HashMap<Colour, Slot> nextSlot;
	
	private int solutionCount;
	
	private int rollouts;
}
