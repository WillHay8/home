package Objects;

import java.util.List;

public class PreviousAttempt {
	
	List<Colour> combination;
	
	int colourAndPosition;
	
	int colour;

	public PreviousAttempt(List<Colour> combination, int colourAndPosition, int colour) {
		super();
		this.combination = combination;
		this.colourAndPosition = colourAndPosition;
		this.colour = colour;
	}
	
	public List<Colour> getCombination() {
		return combination;
	}

	public void setCombination(List<Colour> combination) {
		this.combination = combination;
	}

	public int getColourAndPosition() {
		return colourAndPosition;
	}

	public void setColourAndPosition(int colourAndPosition) {
		this.colourAndPosition = colourAndPosition;
	}

	public int getColour() {
		return colour;
	}

	public void setColour(int colour) {
		this.colour = colour;
	}


	
	
}
