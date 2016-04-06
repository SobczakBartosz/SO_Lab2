import java.util.*;

public class Algorithms {
	
	public int FCFS(Disc disc) {
		int result = 0;
		ArrayList<Request> requestsClone = disc.clone();
		
		while(requestsClone.size() > 1) {
			if(requestsClone.get(1).getTrack() > requestsClone.get(0).getTrack())
				result += requestsClone.get(1).getTrack() - requestsClone.get(0).getTrack();
			else
				result += requestsClone.get(0).getTrack() - requestsClone.get(1).getTrack();
			requestsClone.remove(0);
		}
		return result;
	} // FCFS algorithms
	
	public int SSTF(Disc disc) {
		int result = 0;
		ArrayList<Request> requestsClone = disc.clone();
		
		Collections.sort(requestsClone, new RequestComparator()); //sort by track
		int index = requestsClone.size()/2;
		
		while(requestsClone.size() > 1) {
			if(index == 0) {
				result += requestsClone.get(index+1).getTrack() - requestsClone.get(index).getTrack();
				requestsClone.remove(index);
			} else if(index == requestsClone.size()-1) {
				result += requestsClone.get(index).getTrack() - requestsClone.get(index-1).getTrack();
				requestsClone.remove(index);
				index--;
			} else {
				if(requestsClone.get(index).getTrack() - requestsClone.get(index-1).getTrack() < requestsClone.get(index+1).getTrack() - requestsClone.get(index).getTrack()) {
				result += requestsClone.get(index).getTrack() - requestsClone.get(index-1).getTrack();
				requestsClone.remove(index);
				index--;
				} else {
					result += requestsClone.get(index+1).getTrack() - requestsClone.get(index).getTrack();
					requestsClone.remove(index);
				}
			}
		}
		return result;
	} // SSTF algorithm
	
	public int scan(Disc disc) {
		int result = 0;
		ArrayList<Request> requestsClone = disc.clone();
		
		Collections.sort(requestsClone, new RequestComparator()); //sort by track
		int index = requestsClone.size()/2;
		
		while(index < requestsClone.size()-1) {
			result += requestsClone.get(index+1).getTrack() - requestsClone.get(index).getTrack();
			requestsClone.remove(index);
		}
		result += (disc.getMAX_TRACK() - requestsClone.get(index).getTrack())*2;

		while(requestsClone.size() > 1) {
			result += requestsClone.get(index).getTrack() - requestsClone.get(index-1).getTrack();
			requestsClone.remove(index);
			index--;
		}
		result += requestsClone.get(index).getTrack();

		return result;
	} // SCAN algorithm
	
	public int cscan(Disc disc) {
		int result = 0;
		ArrayList<Request> requestsClone = disc.clone();
		
		Collections.sort(requestsClone, new RequestComparator()); //sort by track
		int index = requestsClone.size()/2;
		
		while(index < requestsClone.size()-1) {
			result += requestsClone.get(index+1).getTrack() - requestsClone.get(index).getTrack();
			requestsClone.remove(index);
		}
		while(requestsClone.size() > 1) {
			result += requestsClone.get(index).getTrack() - requestsClone.get(index-1).getTrack();
			requestsClone.remove(index);
			index--;
		}
		return result;
	} // C-SCAN algorithm
	
	public int EDF(Disc disc) {
		int result = 0;
		ArrayList<Request> requestsClone = disc.clone();
		
		Collections.sort(requestsClone, new RequestComparator2()); //sort by deadline
		
		while(requestsClone.size() > 1) {
			if(requestsClone.get(1).getTrack() - requestsClone.get(0).getTrack() > 0)
				result += (requestsClone.get(1).getTrack() - requestsClone.get(0).getTrack());
			else
				result += (requestsClone.get(0).getTrack() - requestsClone.get(1).getTrack());
			requestsClone.remove(0);
		}
		return result;
	} // EDF algorithm (use real-time requests)
	
}
