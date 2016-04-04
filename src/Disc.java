import java.util.*;

public class Disc {

	private final int MAX_TRACK;
	ArrayList<Request> requests = new ArrayList<Request>();
	
	public Disc(int max, int numberOfRequests, boolean deadline) {
		Random rand = new Random();
		MAX_TRACK = max;
		
		if(deadline == false) {
			for(int i = 0; i < numberOfRequests; i++)
				requests.add(new Request(rand.nextInt(MAX_TRACK+1),false));			
		} else {
			for(int i = 0; i < numberOfRequests; i++)
				requests.add(new Request(rand.nextInt(MAX_TRACK+1),rand.nextBoolean()));
		}	
	} // constructor
	
	public ArrayList<Request> clone() {
		ArrayList<Request> cloneArray = new ArrayList<Request>();
			cloneArray.addAll(requests);
		return cloneArray;
	}
}
