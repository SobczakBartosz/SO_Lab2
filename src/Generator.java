import java.util.Random;

public class Generator {

	public static void show(Disc disc) {
		for(int i =0; i < disc.requests.size(); i++)
			System.out.println(disc.requests.get(i).getTrack());
		System.out.println();
	} // print track of the requests in disc
	
	public static void main(String[] args) {
		
		Algorithms alg = new Algorithms();
		Random rand = new Random();
		
		int avrFCFS = 0;
		int avrSSTF = 0;
		int avrSCAN = 0;
		int avrCSCAN = 0;
		int avrFCFSrt = 0;
		int avrSSTFrt = 0;
		int avrSCANrt = 0;
		int avrCSCANrt = 0;

		
		Disc[] tab = new Disc[100];
		
			for(int i = 0; i < 100; i++) {
				tab[i] = new Disc(500, 30, rand.nextInt(200)+50);
					avrFCFS += alg.FCFS(tab[i],false);
					avrSSTF += alg.SSTF(tab[i],false);
					avrSCAN += alg.scan(tab[i],false);
					avrCSCAN += alg.cscan(tab[i],false);
					avrFCFSrt += alg.FCFS(tab[i],true);
					avrSSTFrt += alg.SSTF(tab[i],true);
					avrSCANrt += alg.scan(tab[i],true);
					avrCSCANrt += alg.cscan(tab[i],true);
			}
			
			avrFCFS /= 100;
			avrSSTF /= 100;
			avrSCAN /= 100;
			avrCSCAN /= 100;
			avrFCFSrt /= 100;
			avrSSTFrt /= 100;
			avrSCANrt /= 100;
			avrCSCANrt /= 100;

			
			System.out.printf("%s %n %s %d %n %s %d %n %s %d %n %s %d %n %s %d  %n %s %d  %n %s %d  %n %s %d %n","Average track for algorithms:", "FCFS: ", avrFCFS,"SSTF: ",
					avrSSTF,"SCAN: ", avrSCAN,"C-SCAN: ", avrCSCAN, "FCFS (hangling real-time) ",  avrFCFSrt, "SSTF (hangling real-time): ",
					avrSSTFrt,"SCAN (hangling real-time): ", avrSCANrt,"C-SCAN (hangling real-time): ", avrCSCANrt);
			
//			for(int i = 0; i < 1; i++) {
//				show(tab[i]);
//			}
	}
}
