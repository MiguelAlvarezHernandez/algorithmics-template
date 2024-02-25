package algstudent.s2;

public class QuicksortInsertion {
	static int[] v;
	 private static int insertionThreshold = 200; 

	public static void quicksortiInsertion(int[] a) {
		quicksortInsertion(a, 0, a.length-1);
	}
		

    private static void quicksortInsertion(int[] a, int left, int right) {
        if (right - left + 1 <= insertionThreshold) {
            // If subarray size is less than or equal to threshold, use insertion sort
            insertionSort(a, left, right);
        } else {
        	int i = left;
    		int j = right - 1;
    		int pivot;
    		
    		if (left < right){ //if there is one element it is not necessary
    			int center = Quicksort.median_of_three(a, left, right);
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
    				quicksortInsertion(a, left, i-1);
    				quicksortInsertion(a, i+1, right);		
    			} //if
    		} //if
        	
        }
    }

    

    /*public static int median_of_three(int[] a, int left, int right) { 
		int center = (left + right) / 2;
		if (a[left] > a[center])
			Vector.interchange(a, left, center);
		if (a[left] > a[right])
			Vector.interchange(a, left, right);
		if (a[center] > a[right])
			Vector.interchange(a, center, right);
		return center;
	}*/

    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    

	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		v = new int[n];

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortiInsertion(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 
}
