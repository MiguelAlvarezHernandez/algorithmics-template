package algstudent.s12;

public class Loop7 {

	public static long loop7(int n) { // O(n4)
		long cont = 0;
		for(int i = 0; i < n; i+=5) {
			for(int j = i; j < n; j+=5) {
				for(int k = j; k < n; k+=5) {
					for(int l = k; l < n; l+=5) {
						cont++;
					}
				}
			}
		}
		return cont;

	}

	public static void main(String arg[]) {
		long c = 0;
		long t1, t2;

		int nTimes = Integer.parseInt(arg[0]);

		System.out.println("n\ttime\trepetions\tcounter");

		for (int n = 100; n <= 819200; n *= 2) {
			t1 = System.currentTimeMillis();

			for (int repetitions = 1; repetitions <= nTimes; repetitions++)
				c = loop7(n);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1) + "\t" + nTimes + "\t\t" + c);
		} // for
	} // main

} 