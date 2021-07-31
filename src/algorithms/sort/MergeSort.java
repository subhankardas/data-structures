package algorithms.sort;

/**
 * Merge Sort is a Divide and Conquer algorithm. It divides the input array into
 * two halves, calls itself for the two halves, and then merges the two sorted
 * halves. The merge() function is used for merging two halves. The merge(arr,
 * l, m, r) is a key process that assumes that arr[l..m] and arr[m+1..r] are
 * sorted and merges the two sorted sub-arrays into one.
 * 
 * Time Complexity: O(N*Log N)
 * 
 * Auxiliary Space: O(N)
 */
public class MergeSort {

	public int[] sort(int[] ar) {
		sort(ar, 0, ar.length - 1);
		return ar;
	}

	/**
	 * DIVIDE AND CONQUER BASED ALGORITHM: Recursively splits arrays into two halves
	 * from midpoint. Then merges two sub-arrays into sorted sub-array.
	 * 
	 * @param ar Original array
	 * @param lb Lower bound of array
	 * @param ub Upper bound of array
	 */
	private void sort(int[] ar, int lb, int ub) {
		if (lb < ub) {
			int mid = lb + ((ub - lb) / 2);

			sort(ar, lb, mid);
			sort(ar, mid + 1, ub);

			merge(ar, lb, mid, ub);
		}
	}

	/**
	 * Merges two sorted arrays into one sorted array.
	 * 
	 * @param ar  Original array
	 * @param lb  Lower bound of array
	 * @param mid Midpoint of array
	 * @param ub  Upper bound of array
	 */
	private void merge(int[] ar, int lb, int mid, int ub) {
		int[] left = new int[mid - lb + 1];
		int[] right = new int[ub - mid];

		// Copy the first sorted array into left
		for (int i = lb, idx = 0; i <= mid; i++, idx++) {
			left[idx] = ar[i];
		}

		// Copy the second sorted array into right
		for (int i = mid + 1, idx = 0; i <= ub; i++, idx++) {
			right[idx] = ar[i];
		}

		// i = Pointer to left array i.e next min. element in left
		// j = Pointer to right array i.e next min. element in right
		// k = Pointer to output array
		int i = 0, j = 0, k = lb;

		// Compare elements from left and right array and put min. to result array
		while (i < mid - lb + 1 && j < ub - mid) {
			if (left[i] < right[j]) {
				ar[k] = left[i++];
			} else {
				ar[k] = right[j++];
			}
			k++;
		}

		// Add remaining left array elements to result
		while (i < mid - lb + 1) {
			ar[k] = left[i++];
			k++;
		}

		// Add remaining right array elements to result
		while (j < ub - mid) {
			ar[k] = right[j++];
			k++;
		}
	}

}
