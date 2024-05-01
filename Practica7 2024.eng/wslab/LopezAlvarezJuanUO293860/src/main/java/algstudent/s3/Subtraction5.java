package algstudent.s3;

/* Class that models T(n)=T(n-1)+O(n)
 * The time complexity is quadratic O(3^(n/2)) a = 3, b = 2, k = 0
 */
public class Subtraction5 {
	public static long rec2(int n) {
		long cont = 0;
		if (n <= 0)
			cont++;
		else {
			rec2(n - 2);
			rec2(n - 2 );
			rec2(n - 2 );
		}
		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2, cont = 0;
		for (int n = 30; n <= 100000; n += 2) {
			t1 = System.currentTimeMillis();

			cont = rec2(n);

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
		} // for
	} // main
} // class