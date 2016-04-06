
public class Request {
	
	private final int track;
	private int deadline;
	private boolean isDone;
	
	public Request(int track, int deadline) {
		this.track = track;
		this.deadline = deadline;
		isDone = false;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public int getTrack() {
		return track;
	}

	public int getDeadline() {
		return deadline;
	}
	
	
}
