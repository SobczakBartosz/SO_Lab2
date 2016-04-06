
public class Request {
	
	private final int track;
	private int deadline;
	private boolean priority;
	
	public Request(int track, int deadline) {
		this.track = track;
		this.deadline = deadline;
		
		if(deadline != 0)
			priority = true;
		else
			priority = false;
	}

	public boolean isPriority() {
		return priority;
	}

	public int getTrack() {
		return track;
	}

	public int getDeadline() {
		return deadline;
	}
	
	public void setDeadline(int deadline) {
		this.deadline = deadline;
		
		if(deadline != 0)
			priority = true;
		else
			priority = false;
	}
	
	
}
