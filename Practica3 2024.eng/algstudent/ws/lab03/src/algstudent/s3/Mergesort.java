package algstudent.s3;

public class Mergesort {
	
	static void mergesort(int left, int right, int[] elements) {
		if (right > left){
		//Get the index of the element in the middle
		int center = (right + left) / 2;
		//Sort the left side of the array
		mergesort(left, center, elements);
		//Sort the right side of the array
		mergesort(center+1, right, elements);
		//Combine both parts
		combine(left, center, center+1, right, elements);
		}
		}
	
	static void combine(int x1, int x2, int y1, int y2, int[] elements) {
		int sizeX = x2 - x1 + 1;
        int sizeY = y2 - y1 + 1;

        // Temporary arrays
        int[] x = new int[sizeX];
        int[] y = new int[sizeY];

        // Copy data to temporary arrays
        System.arraycopy(elements, x1, x, 0, sizeX);
        System.arraycopy(elements, y1, y, 0, sizeY);

        // Merge the temp arrays back into the original array
        int i = 0, j = 0;
        int k = x1; // Initial index of merged subarray
        while (i < sizeX && j < sizeY) {
            if (x[i] <= y[j]) {
                elements[k] = x[i];
                i++;
            } else {
                elements[k] = y[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of x[] if any
        while (i < sizeX) {
            elements[k] = x[i];
            i++;
            k++;
        }

        // Copy remaining elements of y[] if any
        while (j < sizeY) {
            elements[k] = y[j];
            j++;
            k++;
        }
    }
}
