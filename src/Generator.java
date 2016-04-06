import java.util.Random;

public class Generator {

	public static void main(String[] args) {
		
		Algorithms alg = new Algorithms();
		Random rand = new Random();
		
		int avrFCFS = 0;
		int avrSSTF = 0;
		int avrSCAN = 0;
		int avrCSCAN = 0;
		int avrEDF = 0;
		
		Disc[] tab = new Disc[10];
		
			for(int i = 0; i < 10; i++) {
				tab[i] = new Disc(500, 10, rand.nextInt(1000));
					avrFCFS += alg.FCFS(tab[i]);
					avrSSTF += alg.SSTF(tab[i]);
					avrSCAN += alg.scan(tab[i]);
					avrCSCAN += alg.cscan(tab[i]);
					avrEDF += alg.EDF(tab[i]);
			}
			
			avrFCFS /= 10;
			avrSSTF /= 10;
			avrSCAN /= 10;
			avrCSCAN /= 10;
			avrEDF /= 10;
			
			System.out.printf("%s %n %s %d %n %s %d %n %s %d %n %s %d %n %s %d %n","Average track for algorithms:", "FCFS: ", avrFCFS,"SSTF: ",
					avrSSTF,"SCAN: ", avrSCAN,"C-SCAN: ", avrCSCAN, "EDF: ",  avrEDF);
	}
}
