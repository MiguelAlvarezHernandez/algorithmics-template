package alg777777.s1;

import java.util.ArrayList;

public class JavaA2 {
	
	
	public static void main(String[] args) {
		ArrayList<Integer> listPrimes = new ArrayList<Integer>();
		int n = 10000;
		
		for ( int i =0 ; i< 7; i++) {
			long t1 = System.currentTimeMillis();
			listPrimes = listadoPrimos(n);
			long t2 = System.currentTimeMillis();
			System.out.println("n = " + n + " time = " + (t2-t1) + " millisecons");
			n = n*2;
		}
	}
		
	static ArrayList<Integer> listadoPrimos(long n) {
		ArrayList<Integer> listPrimes = new ArrayList<Integer>();
		for ( int i=2; i < n+1; i++) {
			if (primoA2(i))
				listPrimes.add(i);
					
		}
		return listPrimes;
			
	}
		
	static boolean primoA2(int number) {
		for( int i=2; i< number; i++) {
			if (number % i ==0)
				return false;
		}
		return true;
	}
}

