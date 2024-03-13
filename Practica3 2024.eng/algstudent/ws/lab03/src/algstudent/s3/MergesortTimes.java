package algstudent.s3;

public class MergesortTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		String opcion = arg[0];

		for (int n = 250000; n <= 1000000000; n *= 2) {
			v = new int[n];

			if (opcion.compareTo("ordered") == 0)
				Vector.sorted(v);
			else if (opcion.compareTo("reverse") == 0)
				Vector.reverseSorted(v);
			else
				Vector.randomSorted(v);

			t1 = System.currentTimeMillis();

			Mergesort.mergesort(0, v.length-1, v);

			t2 = System.currentTimeMillis();

			System.out.println(n + "\t" + (t2 - t1));
			
//			int[] array = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6, 20, 31, 18, 77, 44, 55, 66, 88, 99, 102, 100};
//
//	        System.out.println("Original array:");
//	        printArray(v);
	        
	        
		}
		
	}
	private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
