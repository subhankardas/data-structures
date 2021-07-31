package algorithms.sort;

/**
 * Insertion Sort: A sub-list is maintained which is always sorted. For example,
 * the lower part of an array is maintained to be sorted. An element which is to
 * be 'insert'ed in this sorted sub-list, has to find its appropriate place and
 * then it has to be inserted there.
 * 
 * Time Complexity: O(N*N)
 * 
 * Auxiliary Space: O(1)
 */
public class InsertionSort {

	public int[] sort(int[] ar) {
		int len = ar.length;
		int i, holePos, key;

		// Loop through the elements from index 1
		for (i = 1; i < len; i++) {
			holePos = i;
			key = ar[holePos];

			// Move elements of [0...holePos-1] greater than key, one step forward
			while (holePos > 0 && ar[holePos - 1] > key) {
				ar[holePos] = ar[holePos - 1];
				holePos = holePos - 1;
			}

			// Insert key at the new hole position
			ar[holePos] = key;
		}

		return ar;
	}

}
