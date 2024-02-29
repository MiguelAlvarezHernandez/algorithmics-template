package algstudent.s3;

public class Substraction5 {
	static long cont;
	
	public static void rec5(int n) {
		
		if (n <= 0)
			cont++;
		else {
			cont++;
			for (long i = 0; i < Math.pow(3, n / 2); i++) {
				rec5(n - 1);
	        }
		}
		
	}

	public static void main(String arg[]) {
		long t1, t2;
		int nTimes = Integer.parseInt (arg [0]);

		for (int n = 100; n <= 100000; n *= 2) {
			t1 = System.currentTimeMillis();

			for (int reps=1; reps<=nTimes;reps++)
			{ 
				rec5(n);
			} 		

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
		} // for
	} // main
} // class
