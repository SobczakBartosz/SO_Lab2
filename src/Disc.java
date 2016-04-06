import java.util.*;

public class Disc {

	private final int MAX_TRACK;
	ArrayList<Request> requests = new ArrayList<Request>();
	
	public Disc(int max_track, int numberOfRequests, int max_deadline) {
		Random rand = new Random();
		MAX_TRACK = max_track;
		
		for(int i = 0; i < numberOfRequests-10; i++)
			requests.add(new Request(rand.nextInt(MAX_TRACK+1),0));
		for(int i = 0; i < 10; i++)
			requests.add(new Request(rand.nextInt(MAX_TRACK+1),rand.nextInt(max_deadline)+1000));
	} // constructor (creates 10 real-time requests)
	
	public int getMAX_TRACK(){
		return MAX_TRACK;
	} // return MAX_TRACK
	
	public ArrayList<Request> clone() {
		ArrayList<Request> cloneArray = new ArrayList<Request>();
			cloneArray.addAll(requests);
		return cloneArray;
	} // return clone of requests list
}
