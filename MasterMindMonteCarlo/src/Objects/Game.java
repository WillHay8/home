package Objects;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private boolean complete;
	
	private List<Attempt> attemptRecord;

	public Game(){
		attemptRecord = new ArrayList<>();
	}
	
	public Game(List<Attempt> attemptRecord) {
		super();
		this.attemptRecord = attemptRecord;
	}

	public List<Attempt> getAttemptRecord() {
		return attemptRecord;
	}

	public void setAttemptRecord(List<Attempt> attemptRecord) {
		this.attemptRecord = attemptRecord;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}	
	
}
