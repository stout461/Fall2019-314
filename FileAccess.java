// This file gives access to the underlying datafile and stores the data in the Workout class.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class FileAccess {
  
  public static boolean loadPrimes(Primes primes, String filename) {
	
	 try {
		 primes.clearPrimes();
		 Scanner scan = new Scanner(new File(filename));
		 while(scan.hasNextBigInteger()) {
			 primes.addPrime(scan.nextBigInteger());
		 }
		 scan.close();
	  } catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  return true;
  }
  
  
  public static boolean loadCrosses(Primes primes, String filename) { 
	  // NEEDS WORK TO BE IMPLEMENTED
	  try {
		 primes.clearCrosses();
		 Scanner scan = new Scanner(new File(filename));
		 while(scan.hasNext()) {
			 String s = scan.nextLine();
			 String[] swag = s.split(",");
			 BigInteger a = new BigInteger(swag[0]);
			 BigInteger b = new BigInteger(swag[1]);
			 primes.addCross(new Pair<BigInteger>(a,b));
		 }
		 scan.close();
	  } catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  return true;
	  
  }
  
  public static boolean savePrimes(Primes primes, String filename)
  {
	FileWriter fileWriter = null;
	try{
		fileWriter = new FileWriter(filename);
		String temp = "";
		for(BigInteger b: primes.iteratePrimes()) {
			temp = b.toString();
			fileWriter.write(temp + "\n");
		}
		fileWriter.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
	
  	return true;
  }
  
  public static boolean saveCrosses(Primes primes, String filename)
  {
	  FileWriter fileWriter = null;
		try{
			
			fileWriter = new FileWriter(filename);
			String temp = "";
			int count =0;
			for(BigInteger b: primes.iterateCrosses()) {
				if(count % 2 == 0) {
					temp = b.toString();
					fileWriter.write(temp + ",");
					count++;
				}else {
					temp = b.toString();
					fileWriter.write(temp + "\n");
					count++;
				}
			}
			fileWriter.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	  	return true;
  	
  }
}
