package com.haywire.processors;

import static com.haywire.processors.CombinationChecker.isCombinationAllowed;
import static com.haywire.processors.GenerateTree.generateFullParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import Objects.Colour;
import Objects.Game;
import Objects.Node;
import Objects.Slot;

public class AI {

	private Game game;
	
	private Node tree;

	private static final Random RANDOM = new Random();
	
	public AI(Game game){
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Node getTree() {
		return tree;
	}

	public void setTree(Node tree) {
		this.tree = tree;
	}
	
	public List<Colour> firstGuess(){
		return randomRollout();
	}
	
	public static List<Colour> randomRollout(){
		List<Colour> combination = new ArrayList<Colour>();
		for(int i=0; i<4; i++){
			combination.add(Colour.randomColour());
		}
		return combination;
	}
	
	public List<Colour> nextGuess(){
		//generate tree
		tree = generateFullParseTree();
		new FullTreeParser(tree, game).parseFullTree();
		
		return bestGuess();
	}
	

	
	public void rollout(){
		Slot nextSlot = chooseNextSlot(tree.getNextSlots());
		rollout(nextSlot, new ArrayList<Colour>());
		tree.incrementRollouts();
	}
	
	public boolean rollout(Slot thisSlot, List<Colour> combination){
		combination.add(thisSlot.getColour());
		if(thisSlot.getSlotNumber()==4){
			boolean combinationAllowed = isCombinationAllowed(combination, game);
			if(combinationAllowed){
				thisSlot.incrementWins();
			}
			thisSlot.incrementRollouts();
			return combinationAllowed;
		}
		boolean combinationAllowed = rollout(chooseNextSlot(thisSlot.getNextSlots()), combination);
		if(combinationAllowed){
			thisSlot.incrementWins();
		}
		thisSlot.incrementRollouts();
		return combinationAllowed;
	}
	
	public Slot chooseNextSlot(Map<Colour, Slot> nextSlot){
		List<Slot> maxMcValueSlots = new ArrayList<>();
		double maxMcValue = 0;
		for(Slot slot: nextSlot.values()){
			double thisValue = slot.getMcValue(tree.getRollouts());
			if(thisValue>maxMcValue){
				maxMcValue = thisValue;
				maxMcValueSlots = new ArrayList<>();
				maxMcValueSlots.add(slot);
			}
			else if(thisValue==maxMcValue){
				maxMcValueSlots.add(slot);
			}
		}
		if(maxMcValueSlots.size()==1){
			return maxMcValueSlots.get(0);
		}
		else{
			return maxMcValueSlots.get(RANDOM.nextInt(maxMcValueSlots.size()));
		}
	}
	
	public List<Colour> bestGuess(){
		Slot firstSlot = chooseBestSlot(tree.getNextSlots());
		return bestGuess(firstSlot, new ArrayList<Colour>());
	}
	
	public List<Colour> bestGuess(Slot thisSlot, List<Colour> combination){
		combination.add(thisSlot.getColour());
		if(thisSlot.getSlotNumber()==4){
			return combination;
		}
		Slot nextSlot = chooseBestSlot(thisSlot.getNextSlots());
		return bestGuess(nextSlot, combination);
	}
	
	public Slot chooseBestSlot(Map<Colour, Slot> slots){
		List<Slot> bestValueSlots = new ArrayList<>();
		double bestValue = 0;
		for(Slot slot: slots.values()){
			double thisValue = slot.getBestValue();
			if(thisValue>bestValue){
				bestValue = thisValue;
				bestValueSlots = new ArrayList<>();
				bestValueSlots.add(slot);
			}
			else if(thisValue==bestValue){
				bestValueSlots.add(slot);
			}
		}
		if(bestValueSlots.size()==1){
			return bestValueSlots.get(0);
		}
		else{
			return bestValueSlots.get(RANDOM.nextInt(bestValueSlots.size()));
		}
	}
}
