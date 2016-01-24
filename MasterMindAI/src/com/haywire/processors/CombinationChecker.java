package com.haywire.processors;

import java.util.ArrayList;


import java.util.List;
import java.util.TreeMap;

import com.haywire.model.Colour;
import com.haywire.model.Game;
import com.haywire.model.Attempt;

public class CombinationChecker {

	private Scorer scorer = new Scorer();
	
	public boolean isCombinationAllowed(List<Colour> combination, Game game){
		boolean allowed = true;
		for(Attempt prevAttempt: game.getAttemptRecord()){
			Attempt prevAttemptScoredAgainstNew = scorer.scoreAttempt(prevAttempt.getCombination(), combination);
			if(!prevAttemptScoredAgainstNew.equals(prevAttempt)){
				allowed = false;
				break;
			}
		}
		return allowed;
	}
	
}
