package algstudent.s2;

public class QuicksortInsertionTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		String opcion = arg[0];
			
			v = new int[16000000];

			if (opcion.compareTo("ordered") == 0)
				Vector.sorted(v);
			else if (opcion.compareTo("reverse") == 0)
				Vector.reverseSorted(v);
			else
				Vector.randomSorted(v);

			t1 = System.currentTimeMillis();

			QuicksortInsertion.quicksort(v, 6);

			t2 = System.currentTimeMillis();

			System.out.println(16000000 + "\t" + (t2 - t1));
		
	}
}
