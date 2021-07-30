package algorithms.sort;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
 * swapping the adjacent elements if they are in wrong order.
 * 
 * Worst and Average Case Time Complexity: O(N*N). Worst case occurs when array
 * is reverse sorted.
 * 
 * Best Case Time Complexity: O(N). Best case occurs when array is already
 * sorted.
 * 
 * Auxiliary Space: O(1)
 */
public class BubbleSort {

	public int[] sort(int[] ar) {
		int len = ar.length;
		int i, j, temp;
		boolean swapped;

		// Points to the initial index (starts from 0)
		for (i = 0; i < len - 1; i++) {
			swapped = false;

			// Points to all other indexes other than initial index (starts after i)
			for (j = i + 1; j < len; j++) {

				// Compares initial index with all other index values and swaps if required
				if (ar[i] > ar[j]) {
					temp = ar[j];
					ar[j] = ar[i];
					ar[i] = temp;
					swapped = true;
				}
			}

			// Internal loop did not swapped any value, already sorted
			if (swapped == false)
				break;
		}

		return ar;
	}

}
