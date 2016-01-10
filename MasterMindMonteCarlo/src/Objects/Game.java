package Objects;

import java.util.List;

public class Game {
	
	private boolean complete;
	
	private List<PreviousAttempt> attemptRecord;

	public Game(List<PreviousAttempt> attemptRecord) {
		super();
		this.attemptRecord = attemptRecord;
	}

	public List<PreviousAttempt> getAttemptRecord() {
		return attemptRecord;
	}

	public void setAttemptRecord(List<PreviousAttempt> attemptRecord) {
		this.attemptRecord = attemptRecord;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}	
	
}
