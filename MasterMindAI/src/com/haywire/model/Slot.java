package com.haywire.model;

import java.util.TreeMap;

public class Slot extends Node{
	
	private Colour colour;
	
	private int slotNumber;
	
	private double mcValue;

	public Slot() {
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}


	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	
	public double getMcValue(int totalRollouts){
		if(getRollouts()==0){
			return Math.sqrt(2.0)*Math.sqrt(Math.log(totalRollouts)/getRollouts());
		}
		return 1.0*getWins()/getRollouts()+Math.sqrt(2.0)*Math.sqrt(Math.log(totalRollouts)/getRollouts());
	}
	
	public double getBestValue(){
		return 1.0*getWins()/getRollouts();
	}
	
}
