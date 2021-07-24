package algorithms.search;

import java.util.Arrays;

/**
 * Exponential Search : The idea is to start with sub-array size 1, compare its
 * last element with x, then try size 2, then 4 and so on until last element of
 * a sub-array is not greater. Once we find an index i (after repeated doubling
 * of i), we know that the element must be present between i/2 and i (Why i/2?
 * because we could not find a greater value in previous iteration).
 * 
 * Time Complexity : O(Log N)
 * 
 * Auxiliary Space : O(1) 
 * 
 * Applications of Exponential Search :
 * 
 * 1. Exponential Binary Search is particularly useful for unbounded searches,
 * where size of array is infinite.
 * 
 * 2. It works better than Binary Search for bounded arrays, and also when the
 * element to be searched is closer to the first element.
 */
public class ExponentialSearch {

	public int find(int[] arr, int val) {
		int len = arr.length;

		// Value in exact start and end positions
		if (val == arr[0])
			return 0;
		if (val == arr[len - 1])
			return len - 1;

		// Find range in which value lies
		int end = 1;
		while (end < len && arr[end] <= val)
			end = end * 2;

		// Binary search in that range
		int pos = Arrays.binarySearch(arr, end / 2, Math.min(end, len - 1), val);
		return pos < 0 ? -1 : pos;
	}

}
