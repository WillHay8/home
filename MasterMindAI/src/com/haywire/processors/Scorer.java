package com.haywire.processors;

import java.util.ArrayList;
import java.util.List;

import com.haywire.model.Attempt;
import com.haywire.model.Colour;

public class Scorer {

	public Attempt scoreAttempt(List<Colour> attemptCombo, List<Colour> masterCombo){
		int colourAndPosition = checkForColourAndPosition(attemptCombo, masterCombo);
		int colourOnly = checkForColourOnly(attemptCombo, masterCombo) - colourAndPosition;
		return new Attempt(attemptCombo, colourAndPosition, colourOnly);
	}
	
	public int checkForColourAndPosition(List<Colour> attemptCombo, List<Colour> masterCombo){
		int colourAndPosition = 0;
		for(int i=0; i<4; i++){
			if(attemptCombo.get(i).equals(masterCombo.get(i))){
				colourAndPosition++;
			}
		}
		return colourAndPosition;
	}
	
	public int checkForColourOnly(List<Colour> attemptCombo, List<Colour> masterCombo){
		List<Colour> masterComboMutable = new ArrayList<>(masterCombo);
		int colourOnly = 0;
		for(Colour attemptColour : attemptCombo){
			for(Colour masterColour : masterComboMutable){
				if(attemptColour.equals(masterColour)){
					colourOnly++;
					masterComboMutable.remove(masterColour);
					break;
				}
			}
		}
		return colourOnly;
	}
}
