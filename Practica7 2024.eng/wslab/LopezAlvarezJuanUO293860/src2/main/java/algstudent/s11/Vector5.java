package algstudent.s11;

/**
 * This program serves to measure times automatically increasing 
 * the size of the problem. In addition, we use a repetition value 
 * determined by nTimes, an argument of the program
 */
public class Vector5 {
	static int[]v;
	public static int maxN = 81920000;
	public static void main(String arg []) {
		int repetitions = Integer.parseInt(arg[0]);
		long t1,t2;
		
		for (int n=10000; n<=maxN ; n*=2){ //n is increased *2   
			  v = new int[n];
			  Vector1.fillIn(v);
			  int[] m = new int[2];
			  t1 = System.currentTimeMillis();
			  //We have to repeat the whole process to be measured
			  for (int repetition=1; repetition<=repetitions; repetition++){  
			     Vector1.maximum(v, m);
			  }
			  t2 = System.currentTimeMillis();
			  System.out.printf("SIZE=%d TIME=%d milliseconds MAX=%d NTIMES=%d\n", n, t2-t1, m[1], repetitions);	
		}//for 
		
	}//main

}
