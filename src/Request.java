
public class Request {
	
	private final int track;
	private boolean deadline;
	private boolean isDone;
	
	public Request(int track, boolean deadline) {
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

	public boolean isDeadline() {
		return deadline;
	}
	
	
}
