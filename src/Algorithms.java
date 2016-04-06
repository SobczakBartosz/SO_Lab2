import java.util.*;

public class Algorithms {
	
	public int FCFS(Disc disc, boolean real_time) {
		int result = 0;
		ArrayList<Request> requestsClone = disc.clone();
		
		if(real_time == true) {
			result += EDF(requestsClone);
		}	
		
		while(requestsClone.size() > 1) {
			result += Math.abs(requestsClone.get(1).getTrack() - requestsClone.get(0).getTrack());
			requestsClone.remove(0);
		}
		return result;
	} // FCFS algorithms
	
	public int SSTF(Disc disc, boolean real_time) {
		int index;
		int result = 0;
		Request first;
		ArrayList<Request> requestsClone = disc.clone();
		
		if(real_time == true)
			result += EDF(requestsClone);
		
		first = requestsClone.get(0);
		Collections.sort(requestsClone, new RequestComparator()); //sort by track
		index = requestsClone.indexOf(first);
		
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
	
	public int scan(Disc disc, boolean real_time) {
		int index;
		int result = 0;
		Request first;
		ArrayList<Request> requestsClone = disc.clone();
		
		if(real_time == true)
			result += EDF(requestsClone);
		
		first = requestsClone.get(0);
		Collections.sort(requestsClone, new RequestComparator()); //sort by track
		index = requestsClone.indexOf(first);

		
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
	
	public int cscan(Disc disc, boolean real_time) {
		int index;
		int result = 0;
		Request first;
		ArrayList<Request> requestsClone = disc.clone();
		
		if(real_time == true)
			result += EDF(requestsClone);
		
		first = requestsClone.get(0);
		Collections.sort(requestsClone, new RequestComparator()); //sort by track
		index = requestsClone.indexOf(first);
		
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
	
	public int EDF(ArrayList<Request> requests) {
		int result = 0;
		int current = 0;
		int index = 1;

		Collections.sort(requests, new RequestComparator2()); //sort by deadline
		Collections.reverse(requests);
		requests.get(current).setDeadline(0);
		
		while(requests.get(index).isPriority() == true) {
			if(requests.get(index).getDeadline() > Math.abs(requests.get(index).getTrack() - requests.get(current).getTrack())) {
				result += Math.abs(requests.get(index).getTrack() - requests.get(current).getTrack());
				requests.remove(current);
				current = index;
				
			} else
				requests.get(index).setDeadline(0);
			index++;
		}
		Request tmp = requests.get(0);
		requests.set(0, requests.get(current));
		requests.set(current, tmp);
		
		return result;
	} //EDF algorithm for handling real-time requests

}
