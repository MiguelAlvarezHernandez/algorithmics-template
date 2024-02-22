package algstudent.s2;

public class QuicksortInsertion {
	static int[] v;
	 private static int insertionThreshold = 200; 

	public static void quicksortiInsertion(int[] a) {
		quicksortiInsertion(a, 0, a.length-1);
	}
	
	/* Sorting by the Insertion method */
	/*public static void quicksortiInsertion(int[] a, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
	        int pivot = a[i];
	        int j = i - 1;

	        while (j >= left && pivot < a[j]) {
	            a[j + 1] = a[j];
	            j--;
	        }

	        a[j + 1] = pivot;
	    }
	}*/
	

    private static void quicksortiInsertion(int[] a, int left, int right) {
        if (right - left + 1 <= insertionThreshold) {
            // If subarray size is less than or equal to threshold, use insertion sort
            insertionSort(a, left, right);
        } else {
        	int i = left;
    		int j = right - 1;
    		int pivot;
    		
    		if (left < right){ //if there is one element it is not necessary
    			int center = medianOfThree(a, left, right);
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
    				quicksortiInsertion(a, left, i-1);
    				quicksortiInsertion(a, i+1, right);		
    			} //if
    		} //if
        	
        	
        	
            /*// Otherwise, use quicksort
            int partitionIndex = partition(array, left, right);
            quicksortiInsertion(array, left, partitionIndex - 1);
            quicksortiInsertion(array, partitionIndex + 1, right);*/
        }
    }

    /*private static int partition(int[] array, int left, int right) {
        // Choose pivot as the median of three elements
        int pivot = medianOfThree(array, left, right);
        int pivotValue = array[pivot];
        // Move pivot to the end to simplify partitioning
        swap(array, pivot, right);

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivotValue) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }*/

    private static int medianOfThree(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[left] > array[mid]) {
            swap(array, left, mid);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[mid] > array[right]) {
            swap(array, mid, right);
        }
        return mid;
    }

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

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
