package com.haywire.model;

import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public enum Colour {

	EMPTY, RED, YELLOW, GREEN, BLUE, BLACK, WHITE;
	
	  private static final List<Colour> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	  private static final int SIZE = VALUES.size();
	  private static final Random RANDOM = new Random();

	  public static Colour randomColour()  {
	    return VALUES.get(RANDOM.nextInt(SIZE));
	  }
	  
	  public static List<Colour> cloneList(List<Colour> combo){
		  List<Colour> clone = new ArrayList<>();
		  for(Colour colour: combo){
			  clone.add(colour);
		  }
		  return clone;
	  }
}
