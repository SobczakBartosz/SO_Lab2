import java.util.Random;

public class Generator {

	public static void show(Disc disc) {
		for(int i =0; i < disc.requests.size(); i++)
			System.out.println(disc.requests.get(i).getTrack());
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Algorithms alg = new Algorithms();
		Random rand = new Random();
		
		int avrFCFS = 0;
		int avrSSTF = 0;
		int avrSCAN = 0;
		int avrCSCAN = 0;
		int avrEDF = 0;
		
		Disc[] tab = new Disc[100];
		
			for(int i = 0; i < 100; i++) {
				tab[i] = new Disc(500, 30, rand.nextInt(200));
					avrFCFS += alg.FCFS(tab[i]);
					avrSSTF += alg.SSTF(tab[i]);
					avrSCAN += alg.scan(tab[i]);
					avrCSCAN += alg.cscan(tab[i]);
					avrEDF += alg.EDF(tab[i]);
			}
			
			avrFCFS /= 100;
			avrSSTF /= 100;
			avrSCAN /= 100;
			avrCSCAN /= 100;
			avrEDF /= 100;
			
			System.out.printf("%s %n %s %d %n %s %d %n %s %d %n %s %d %n %s %d %n","Average track for algorithms:", "FCFS: ", avrFCFS,"SSTF: ",
					avrSSTF,"SCAN: ", avrSCAN,"C-SCAN: ", avrCSCAN, "EDF: ",  avrEDF);
			
//			for(int i = 0; i < 1; i++) {
//				show(tab[i]);
//			}
	}
}
