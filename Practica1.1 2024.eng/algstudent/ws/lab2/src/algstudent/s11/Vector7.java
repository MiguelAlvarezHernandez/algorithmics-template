package algstudent.s11;

public class Vector7 {


		static int[]v;
		
		public static void main(String arg []) {
			int repetitions =  Integer.parseInt(arg[0]);
			long t1,t2;
			
			for (int n=10000; n<=Integer.MAX_VALUE; n*=2){ //n is increased *5   
				  v = new int[n];
				  Vector1.fillIn(v);
				  int[] m = new int[n];
				  Vector1.fillIn(m);
				  t1 = System.currentTimeMillis();
				  //We have to repeat the whole process to be measured
				  for (int repetition=1; repetition<=repetitions; repetition++){    	
				     Vector1.matches2(v, m);
				  }
				  t2 = System.currentTimeMillis();
				  System.out.printf("SIZE=%d TIME=%d milliseconds NTIMES=%d\n", n, t2-t1, repetitions);	
			}//for 
			
		}//main
}