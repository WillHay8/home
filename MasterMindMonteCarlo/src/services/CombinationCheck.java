package services;

import java.util.ArrayList;
import static services.Scoring.scoreAttempt;
import java.util.List;
import java.util.TreeMap;

import Objects.Colour;
import Objects.Game;
import Objects.Attempt;

public class CombinationCheck {

	public static boolean isCombinationAllowed(List<Colour> combination, Game game){
		boolean allowed = true;
		for(Attempt prevAttempt: game.getAttemptRecord()){
			Attempt prevAttemptScoredAgainstNew = scoreAttempt(prevAttempt.getCombination(), combination);
			if(!prevAttemptScoredAgainstNew.equals(prevAttempt)){
				allowed = false;
				break;
			}
		}
		return allowed;
	}
	
}
