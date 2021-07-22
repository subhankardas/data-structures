package algorithms.search;

/**
 * Jump Search is a searching algorithm for sorted arrays. The basic idea is to
 * check fewer elements (than linear search) by jumping ahead by fixed steps or
 * skipping some elements in place of searching all elements.
 * 
 * Time Complexity : O(square root of(N))
 * 
 * Auxiliary Space : O(1)
 */
public class JumpSearch {

	public int find(int[] arr, int val) {
		int len = arr.length;
		int STEP_COUNT = (int) Math.sqrt(len); // Steps count

		// Start with first block i.e. 0 to STEP_COUNT
		int prev = 0;
		int step = STEP_COUNT;

		// While search value does not exceeds next block value
		while (val > arr[step - 1]) {
			// Value found in current block
			if (arr[prev] == val)
				return prev;
			if (arr[step] == val)
				return step;

			// Increment for next block
			prev = step;
			step += STEP_COUNT;

			// Search exceeds complete array
			if (step > len)
				return -1;
		}

		// Linear search in the found block
		for (int st = prev; st <= step; st++) {
			if (arr[st] == val)
				return st;
		}

		return -1;
	}

}
