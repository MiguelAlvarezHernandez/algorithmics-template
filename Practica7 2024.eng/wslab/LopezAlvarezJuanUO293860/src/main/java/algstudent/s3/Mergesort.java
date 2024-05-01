package algstudent.s3;
import algstudent.s2.Vector;

/* This program is used to order n elements with Mergesort */
public class Mergesort {
	static int[] v;
	
	public static void mergesort(int[] a) {
		mergesort(a, 0, a.length-1);
	}
	
	public static void mergesort(int[] a, int left, int right) {
		if (right>left){ 
			int center = (right+left)/2;
			mergesort(a,left, center);
			mergesort(a, center+1, right);
			combine(left, center, center+1, right, a);
		}
		
	} 


	private static void combine(int left, int center, int center2, int right, int[] a) {
		int sizeA = center - left + 1;
		int sizeB = right - center2 +1;
		int[] A = new int[sizeA];
		int[] B = new int[sizeB];
		for(int i = 0; i<sizeA; i++) {
			A[i] = a[left + i];
		}
		for(int i = 0; i<sizeB; i++) {
			B[i] = a[center2 + i];
		}
		int idxA = 0;
		int idxB = 0;
		int i = left;
		while(idxA < sizeA && idxB < sizeB) {
			if(A[idxA] < B[idxB]) {
				a[i] = A[idxA];
				idxA++;
			}
			else {
				a[i]=B[idxB];
				idxB++;
			}
			i++;
		}
		for(int j = idxB ; j<sizeB ; j++) {
			a[i] = B[j];
			i++;
		}
		for(int j = idxA ; j<sizeA ; j++) {
			a[i] = A[j];
			i++;
		}
		
		
	}

	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		v = new int[n];

		Vector.sorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		mergesort(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.reverseSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		mergesort(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		mergesort(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 

}
