package com.haywire.model;

import java.util.List;

public class Attempt {
	
	List<Colour> combination;
	
	int colourAndPosition;
	
	int colourOnly;

	public Attempt(List<Colour> combination) {
		this.combination = combination;
	}
	
	public Attempt(List<Colour> combination, int colourAndPosition, int colourOnly){
		this.combination = combination;
		this.colourAndPosition = colourAndPosition;
		this.colourOnly = colourOnly;
	}
	
	public void incrementColour(){
		colourOnly++;
	}
	
	public void decrementColour(){
		colourOnly--;
	}
	
	public void incrementColourAndPosition(){
		colourAndPosition++;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colourOnly;
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
		if (colourOnly != other.colourOnly)
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

	public int getColourOnly() {
		return colourOnly;
	}

	public void setColourOnly(int colourOnly) {
		this.colourOnly = colourOnly;
	}


	
	
}
