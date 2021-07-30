package algorithms.sort;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum
 * element (considering ascending order) from unsorted part and putting it at
 * the beginning. The algorithm maintains two sub-arrays in a given array.
 * 
 * 1) The sub-array which is already sorted.
 * 
 * 2) Remaining sub-array which is unsorted.
 * 
 * In every iteration of selection sort, the minimum element (considering
 * ascending order) from the unsorted sub-array is picked and moved to the
 * sorted sub-array.
 * 
 * Time Complexity: O(N*N) as there are two nested loops.
 * 
 * Auxiliary Space: O(1)
 */
public class SelectionSort {

	public int[] sort(int[] ar) {
		int len = ar.length;
		int i, j, minIdx, temp;

		// Move boundary of unsorted sub-array
		for (i = 0; i < len - 1; i++) {
			minIdx = i;

			// Find the min. element index
			for (j = i + 1; j < len; j++) {
				if (ar[j] < ar[minIdx])
					minIdx = j;
			}

			// Swap min. element with sorted sub-array last element
			temp = ar[minIdx];
			ar[minIdx] = ar[i];
			ar[i] = temp;
		}

		return ar;
	}

}
