import java.util.*;

public class Algorithms {
	
	public int FCFS(Disc disc) {
		int result = 0;
		ArrayList<Request> requestsClone = disc.clone();
		
		while(requestsClone.size() > 1) {
			result += requestsClone.get(1).getTrack() - requestsClone.get(0).getTrack();
			requestsClone.remove(0);
		}
		return result;
	} // FCFS algorithms
	
	public int SSTF(Disc disc) {
		int index;
		int result = 0;
		Request current = null;
		Request tmp = null;
		ArrayList<Request> requestsClone = disc.clone();
		
		Collections.sort(requestsClone, new RequestComparator()); //sort by track
		index = requestsClone.size()/2;
		current = requestsClone.get(index);
		
		while(requestsClone.size() > 1) {
			if(index == 0) {
				tmp = requestsClone.get(1);
				result += current.getTrack() - tmp.getTrack();
				requestsClone.remove(current);
				current = tmp;
			} else if(index == requestsClone.size()-1) {
				tmp = requestsClone.get(requestsClone.size()-2);
				result += current.getTrack() - tmp.getTrack();
				requestsClone.remove(current);
				current = tmp;
				index--;
			} else {
				if(current.getTrack() - requestsClone.get(index-1).getTrack() > requestsClone.get(index+1).getTrack() - current.getTrack()) {
				tmp = requestsClone.get(index-1);
				result += current.getTrack() - tmp.getTrack();
				requestsClone.remove(current);
				current = tmp;
				index--;
				} else {
					tmp = requestsClone.get(index+1);
					result += tmp.getTrack() - current.getTrack();
					requestsClone.remove(current);
					current = tmp;
				}
			}
		}
		return result;
	} // SSTF algorithm
	
	public int scan(Disc disc) {
		int index;
		int result = 0;
		Request current = null;
		Request tmp = null;
		ArrayList<Request> requestsClone = disc.clone();
		
		Collections.sort(requestsClone, new RequestComparator()); //sort by track
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
		
		Collections.sort(requestsClone, new RequestComparator()); //sort by track
		index = requestsClone.size()/2;
		current = requestsClone.get(index);
		
		while(index < requestsClone.size()-1) {
			tmp = requestsClone.get(index+1);
			result += tmp.getTrack() - current.getTrack();
			requestsClone.remove(current);
			current = tmp;	
		}
		while(requestsClone.size() <= 1) {
			result += current.getTrack() - requestsClone.get(index-1).getTrack();
			requestsClone.remove(index);
		}
		return result;
	} //c-scan algorithm
	
	public int EDF(Disc disc) {
		int index;
		int result = 0;
		Request current = null;
		Request tmp = null;
		ArrayList<Request> requestsClone = disc.clone();
		
		Collections.sort(requestsClone, new RequestComparator2()); //sort by deadline
		current = requestsClone.get(0);
		
		while(requestsClone.size() > 1) {
			result += requestsClone.get(1).getTrack() - requestsClone.get(0).getTrack();
			requestsClone.remove(0);
		}
		return result;
	} // EDF algorithm (use real-time requests)
	
//	public int FD_SCAN(Disc disc) {
//		int result = 0;
//		
//		return result;
//	} // FD_SCAN algorithm (use real-time requests)
//	
}
