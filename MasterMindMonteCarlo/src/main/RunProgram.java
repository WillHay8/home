package main;

import java.util.ArrayList;
import java.util.List;

import Objects.Colour;
import Objects.Game;
import Objects.PreviousAttempt;
import Objects.Root;
import services.AI;

public class RunProgram {
	
	public static void main(String[] args){
		runProgram();
	}
	
	public static void runProgram(){
		Game game = new Game();
		AI ai = new AI(game);
		
		ai.firstGuess();
		
		while(!game.isComplete()){
			outputGuess(ai.nextGuess());
			inputScore();
		}
		
		outputGameWon(game.getAttemptRecord().size());
		
	}

	

	
	public static void outputCombination(List<Colour> combination){
		for(Colour colour: combination){
			System.out.println(colour + ", ");
		}
	}
	
	public static void outputGameWon(int goes){
		System.out.println("Game won! Combination guessed in "+goes+" goes");
}
