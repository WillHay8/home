package com.haywire.model;

import java.util.Map;

public class Node {

	Map<Colour, Slot> nextSlot;
	
	int rollouts;
	
	int wins;

	public Map<Colour, Slot> getNextSlot() {
		return nextSlot;
	}

	public void setNextSlot(Map<Colour, Slot> nextSlot) {
		this.nextSlot = nextSlot;
	}

	public int getRollouts() {
		return rollouts;
	}

	public void setRollouts(int rollouts) {
		this.rollouts = rollouts;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
}
