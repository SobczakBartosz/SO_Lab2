import java.util.*;

public class Algorithms {
	
	public int scan(Disc disc) {
		int index;
		int result = 0;
		Request current = null;
		Request tmp = null;
		ArrayList<Request> requestsClone = disc.clone();
		
		Collections.sort(requestsClone, new RequestComparator());
		index = requestsClone.size()/2;
		current = requestsClone.get(index);
		
		while(index < requestsClone.size()-1) {
			tmp = requestsClone.get(index+1);
			result += tmp.getTrack() - current.getTrack();
			requestsClone.remove(current);
			current = tmp;	
		}
		result += (disc.getMAX_TRACK() - current.getTrack())*2;
		while(requestsClone.size() <= 1) {
			result += requestsClone.get(index-1).getTrack();
			requestsClone.remove(index);
		}
		return result;
	} // scan algorithm
	
	public int cscan(Disc disc) {
		int index;
		int result = 0;
		Request current = null;
		Request tmp = null;
		ArrayList<Request> requestsClone = disc.clone();
		
		Collections.sort(requestsClone, new RequestComparator());
		index = requestsClone.size()/2;
		current = requestsClone.get(index);
		
		while(index < requestsClone.size()-1) {
			tmp = requestsClone.get(index+1);
			result += tmp.getTrack() - current.getTrack();
			requestsClone.remove(current);
			current = tmp;	
		}
		while(requestsClone.size() <= 1) {
			result += requestsClone.get(index-1).getTrack();
			requestsClone.remove(index);
		}
		return result;
	} //cscan algorithm
	
}
