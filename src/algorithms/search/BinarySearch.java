package algorithms.search;

/**
 * Binary Search: Search a sorted array by repeatedly dividing the search
 * interval in half. Begin with an interval covering the whole array. If the
 * value of the search key is less than the item in the middle of the interval,
 * narrow the interval to the lower half. Otherwise, narrow it to the upper
 * half. Repeatedly check until the value is found or the interval is empty.
 * 
 * Time Complexity: O(Log N)
 * 
 * Auxiliary Space: O(N)
 */
public class BinarySearch {

	public int find(int[] arr, int val) {
		return find(arr, val, 0, arr.length - 1);
	}

	private int find(int[] arr, int val, int start, int end) {
		int mid = start + (end - start) / 2;

		// Check if range is valid
		if (start <= end) {
			if (val == arr[mid])
				return mid;
			else if (val < arr[mid])
				// Value less than mid value, search in the left half
				return find(arr, val, start, mid - 1);
			else
				// Value more than mid value, search in the right half
				return find(arr, val, mid + 1, end);
		}

		return -1;
	}

}
