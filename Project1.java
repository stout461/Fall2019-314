import java.math.BigInteger;
import java.io.FileWriter;

public class Project1 {
	public static void main(String[] args) 
	{
		// Instantiate Primes Class
		Primes p = new Primes();
	
		
		p.generatePrimes(BigInteger.ONE, 1000);
		
		p.printPrimes();
		p.generateTwinPrimes();
		
		System.out.println(" size of last prime " + p.sizeofLastPrime());
		p.generateHexPrimes();
		
		Pair<Integer> a = p.sizeofLastCross();
		
		System.out.println(" the size of last cross is " + a.left() + " and "  + a.right());
		p.iteratePrimes();
		
		System.out.println("------iterate primes ---------------------------------------------");
		for(BigInteger b: p.iteratePrimes()) {
			System.out.println(b);
		}
		System.out.println("-------iterate cross-----------------------------------------------------");
		for(BigInteger b: p.iterateCrosses()) {
			System.out.println(b);
		}
		FileAccess test = new FileAccess();
		FileAccess.saveCrosses(p, "test.txt");
		FileAccess.loadCrosses(p,"test.txt");
		
		//p.printPrimes();
		MainWindow mw = new MainWindow(Config.APPLICATIONNAME, p);
	}
}
