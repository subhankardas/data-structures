package algorithms.search;

/**
 * Fibonacci Search is a comparison-based technique that uses Fibonacci numbers
 * to search an element in a sorted array.
 * 
 * Algorithm: Let the searched element be x. The idea is to first find the
 * smallest Fibonacci number that is greater than or equal to the length of the
 * given array. Let the found Fibonacci number be fib (m’th Fibonacci number).
 * We use (m-2)’th Fibonacci number as the index (If it is a valid index). Let
 * (m-2)’th Fibonacci Number be i, we compare arr[i] with x, if x is same, we
 * return i. Else if x is greater, we recur for sub-array after i, else we recur
 * for sub-array before i.
 * 
 * Time complexity : O(Log N)
 */
public class FibonacciSearch {

	public int find(int[] arr, int val) {
		int len = arr.length;

		int fib2 = 0; // First fibonacci no.
		int fib1 = 1; // Second fibonacci no.
		int fib = fib2 + fib1;

		// Find the fibonacci no. greater or equal to length
		while (fib < len) {
			fib2 = fib1;
			fib1 = fib;
			fib = fib2 + fib1;
		}

		// Offset from front of array
		int offset = -1;

		/*
		 * While there are elements to be inspected. Note that we compare arr[fib2] with
		 * value. When fib becomes 1, fib2 becomes 0.
		 */
		while (fib > 1) {
			int pos = Math.min(offset + fib2, len - 1);

			/*
			 * If value is greater than the value at index fib2, cut the sub-array array
			 * from offset to pos
			 */
			if (arr[pos] < val) {
				fib = fib1;
				fib1 = fib2;
				fib2 = fib - fib1;
				offset = pos;
			}
			/*
			 * If value is less than the value at index fib2, cut the sub-array after pos+1
			 */
			else if (arr[pos] > val) {
				fib = fib2;
				fib1 = fib1 - fib2;
				fib2 = fib - fib1;
			} else
				// Element found at pos
				return pos;
		}

		// If fib1 equals 1, check last element
		if (fib1 == 1 && arr[len - 1] == val)
			return len - 1;

		return -1;
	}

}
