package algstudent.s2;

/* This program is used to sort n elements with a quadratic algorithm
except if the vector is initially ordered or nearly ordered,
which is of linear complexity (INSERTION) */
public class QuicksortInsertion {
	static int[] v;
	
	
	public static void main(String arg[]) {
		v = new int[20];

		Vector.sorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksort(v,5);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.reverseSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksort(v,5);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksort(v, 5);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 
	
	/* Sorting by the Quicksort + Insertion method */
	public static void quicksortInsertion(int[] a, int left, int right) {
		int j;
		int pivot;
		
		for (int i =  left+1; i <= right; i++) {
			pivot = a[i];
			j = i-1;
			
			while (j >= left && pivot < a[j]) {
				a[j+1] = a[j];
				j--;
			}
			
			a[j+1] = pivot;
		}
	}
	
	/*get the position of the median of the three (left, right and 
	 the element which position is in the center between them, and
	 move the elements to order them */
	public static int median_of_three(int[] a, int left, int right) { 
		int center = (left + right) / 2;
		if (a[left] > a[center])
			Vector.interchange(a, left, center);
		if (a[left] > a[right])
			Vector.interchange(a, left, right);
		if (a[center] > a[right])
			Vector.interchange(a, center, right);
		return center;
	}
	
	public static void quicksort(int[] a, int thresholdSize) {
		quicksort(a, 0, a.length-1, thresholdSize);
	}
	
	public static void quicksort(int[] a, int left, int right, int thresholdSize) {
		int i = left;
		int j = right - 1;
		int pivot;
		
		if (right - left > thresholdSize){ //if there are less elements than the threshold we do insertion
			int center = median_of_three(a, left, right);
			//if there are less than or equal to 3 elements, there are just ordered
			if ((right - left) >= 3){ 
				pivot = a[center]; //choose the pivot
				Vector.interchange(a, center, right); //hide the pivot

				do {         
			    	while (a[i] <= pivot && i < right) i++; //first element > pivot
			    	while (a[j] >= pivot && j > left) j--; //first element < pivot
			        if (i < j) Vector.interchange(a, i, j);
			    } while (i < j);   //end while
				
				//we set the position of the pivot
				Vector.interchange(a, i, right);
				quicksort(a, left, i-1, thresholdSize);
				quicksort(a, i+1, right, thresholdSize);		
			} //if
		} //if
		else
			quicksortInsertion(a, left, right);
	}

}
