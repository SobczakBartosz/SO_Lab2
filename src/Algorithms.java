import java.util.*;

public class Algorithms {
	
	public int scan(Disc disc) {
		int result = 0;
		int index;
		Request current = null;
		Request tmp = null;
		ArrayList<Request> requestsClone = disc.clone();
		
		Collections.sort(requestsClone, new RequestComparator());
		index = requestsClone.size()/2;
		current = requestsClone.get(index);

//		Iterator it = requestsClone.iterator();
		
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
	}
}
