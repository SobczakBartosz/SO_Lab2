import java.util.ArrayList;
import java.util.Random;

public class Disc {

	private final int MAX_TRACK;
	ArrayList<Request> disc = new ArrayList<Request>();
	
	public Disc(int max, int numberOfRequests, boolean deadline) {
		Random rand = new Random();
		MAX_TRACK = max;
		
		if(deadline == false) {
			for(int i = 0; i < numberOfRequests; i++)
				disc.add(new Request(rand.nextInt(MAX_TRACK+1),false));			
		} else {
			for(int i = 0; i < numberOfRequests; i++)
				disc.add(new Request(rand.nextInt(MAX_TRACK+1),rand.nextBoolean()));
		}	
	} // constructor
	
}
