package test.com.haywire.processors;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.haywire.model.Attempt;
import com.haywire.model.Colour;
import com.haywire.processors.Scorer;

public class ScorerUTest {

	@Test
	public void randomComboTest() {
		Scorer scorer = new Scorer();
		List<Colour> masterCombo = Arrays.asList(Colour.BLACK, Colour.BLUE, Colour.GREEN, Colour.RED);
		List<Colour> attemptCombo = Arrays.asList(Colour.BLACK, Colour.GREEN, Colour.YELLOW, Colour.WHITE);
		int colourAndPosition = 1;
		int colourOnly = 1;
		Attempt expected = new Attempt(attemptCombo, colourAndPosition, colourOnly);
		Attempt result = scorer.scoreAttempt(attemptCombo, masterCombo);
		assertEquals("attempt was not scored correctly", expected, result);
	}
	
	@Test
	public void doubleInAttemptTest() {
		Scorer scorer = new Scorer();
		List<Colour> masterCombo = Arrays.asList(Colour.BLACK, Colour.BLACK, Colour.GREEN, Colour.RED);
		List<Colour> attemptCombo = Arrays.asList(Colour.BLACK, Colour.GREEN, Colour.YELLOW, Colour.WHITE);
		int colourAndPosition = 1;
		int colourOnly = 1;
		Attempt expected = new Attempt(attemptCombo, colourAndPosition, colourOnly);
		Attempt result = scorer.scoreAttempt(attemptCombo, masterCombo);
		assertEquals("attempt was not scored correctly", expected, result);
	}
	
	@Test
	public void doubleInMasterTest() {
		Scorer scorer = new Scorer();
		List<Colour> masterCombo = Arrays.asList(Colour.BLACK, Colour.BLUE, Colour.GREEN, Colour.RED);
		List<Colour> attemptCombo = Arrays.asList(Colour.BLACK, Colour.GREEN, Colour.BLACK, Colour.WHITE);
		int colourAndPosition = 1;
		int colourOnly = 1;
		Attempt expected = new Attempt(attemptCombo, colourAndPosition, colourOnly);
		Attempt result = scorer.scoreAttempt(attemptCombo, masterCombo);
		assertEquals("attempt was not scored correctly", expected, result);
	}
	
	@Test
	public void doubleInBothTest() {
		Scorer scorer = new Scorer();
		List<Colour> masterCombo = Arrays.asList(Colour.BLACK, Colour.BLACK, Colour.GREEN, Colour.RED);
		List<Colour> attemptCombo = Arrays.asList(Colour.BLACK, Colour.GREEN, Colour.BLACK, Colour.WHITE);
		int colourAndPosition = 1;
		int colourOnly = 2;
		Attempt expected = new Attempt(attemptCombo, colourAndPosition, colourOnly);
		Attempt result = scorer.scoreAttempt(attemptCombo, masterCombo);
		assertEquals("attempt was not scored correctly", expected, result);
	}

}
