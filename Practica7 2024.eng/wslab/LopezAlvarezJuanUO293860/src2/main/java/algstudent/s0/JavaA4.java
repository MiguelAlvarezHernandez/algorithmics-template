package algstudent.s0;

import java.util.ArrayList;

public class JavaA4 {

	public static void main(String[] args) {
		int n = 10000;
			    for(int i = 0; i < 7; i++) {		//casos in range(7):
			    	long t1 = System.currentTimeMillis();
					ArrayList<Integer> primes = listadoPrimos(n);
					long t2 = System.currentTimeMillis();
					System.out.println("n =" + n + "***" + "time =" + (t2-t1) + " milliseconds)");
			        n = n*2;
			    }
	}
	
	public static ArrayList<Integer> listadoPrimos(int n) {
	    ArrayList<Integer> primes = new ArrayList<>();
	    for(int i = 2; i < n+1; i++) {	//i in range (2, n+1):
	        if(primoA4(i))
	            primes.add(i);
	    }
	    return primes;
	}
	
	public static boolean primoA4(int m) {
	    for (int i = 2; i <= Math.sqrt(m); i++){	//i in range (2,m):
	        if(m%i==0) {
	            return false;
	        }
	    }
	    return true;
	}

}
