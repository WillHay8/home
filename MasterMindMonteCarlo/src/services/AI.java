package services;

import static services.CombinationCheck.isCombinationAllowed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import Objects.Colour;
import Objects.Game;
import Objects.Root;
import Objects.Slot;

public class AI {

	private Game game;
	
	private Root tree;

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

	public Root getTree() {
		return tree;
	}

	public void setTree(Root tree) {
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
		tree = new Root();
		
		for(int i=0; i<500; i++){
			rollout();
		}
		
		return bestGuess();
	}
	
	public void rollout(){
		Slot nextSlot = chooseNextSlot(tree.getFirstSlot());
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
		boolean combinationAllowed = rollout(chooseNextSlot(thisSlot.getNextSlot()), combination);
		if(combinationAllowed){
			thisSlot.incrementWins();
		}
		thisSlot.incrementRollouts();
		return combinationAllowed;
	}
	
	public Slot chooseNextSlot(TreeMap<Colour, Slot> nextSlot){
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
		Slot firstSlot = chooseBestSlot(tree.getFirstSlot());
		return bestGuess(firstSlot, new ArrayList<Colour>());
	}
	
	public List<Colour> bestGuess(Slot thisSlot, List<Colour> combination){
		combination.add(thisSlot.getColour());
		if(thisSlot.getSlotNumber()==4){
			return combination;
		}
		Slot nextSlot = chooseBestSlot(thisSlot.getNextSlot());
		return bestGuess(nextSlot, combination);
	}
	
	public Slot chooseBestSlot(TreeMap<Colour, Slot> slots){
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
