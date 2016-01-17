package Objects;

import java.util.List;

public class Attempt {
	
	List<Colour> combination;
	
	int colourAndPosition;
	
	int colour;

	public Attempt(List<Colour> combination) {
		this.combination = combination;
	}
	
	public void incrementColour(){
		colour++;
	}
	
	public void decrementColour(){
		colour--;
	}
	
	public void incrementColourAndPosition(){
		colourAndPosition++;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colour;
		result = prime * result + colourAndPosition;
		result = prime * result + ((combination == null) ? 0 : combination.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attempt other = (Attempt) obj;
		if (colour != other.colour)
			return false;
		if (colourAndPosition != other.colourAndPosition)
			return false;
		if (combination == null) {
			if (other.combination != null)
				return false;
		} else if (!combination.equals(other.combination))
			return false;
		return true;
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
