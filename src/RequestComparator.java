import java.util.Comparator;

public class RequestComparator implements Comparator<Request>{

	@Override
	public int compare(Request o1, Request o2) {
		// TODO Auto-generated method stub
		return o1.getTrack()-o2.getTrack();
	}
}