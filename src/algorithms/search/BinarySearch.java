package algorithms.search;

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
