package data_structures.hashing.simple;

/**
 * Index Mapping (or Trivial Hashing) with negatives allowed. Given a limited
 * range array contains both positive and non-positive numbers, i.e., elements
 * are in the range from -MAX to +MAX. Our task is to search if some number is
 * present in the array or not in O(1) time.
 * 
 * Since range is limited, we can use index mapping (or trivial hashing). We use
 * values as the index in a big array. Therefore we can search and insert
 * elements in O(1) time.
 */
public class IndexMap {

	private static final int MAX = 100;
	private static boolean DATA[][];

	public IndexMap() {
		DATA = new boolean[MAX + 1][2];
	}

	public void insert(int i) {
		// Set the index 1 for positive values and index 0 for negative ones
		if (i >= 0 && i <= MAX) {
			DATA[i][1] = true;
		} else if (i < 0 && Math.abs(i) <= MAX) {
			DATA[Math.abs(i)][0] = true;
		} else {
			throw new RuntimeException("Out of maximum limit for value " + i + ", range is -" + MAX + " to +" + MAX);
		}
	}

	public void remove(int i) {
		// Reset the index 1 for positive values and index 0 for negative ones
		if (i >= 0 && i <= MAX) {
			DATA[i][1] = false;
		} else if (i < 0 && Math.abs(i) <= MAX) {
			DATA[Math.abs(i)][0] = false;
		} else {
			throw new RuntimeException("Out of maximum limit for value " + i + ", range is -" + MAX + " to +" + MAX);
		}
	}

	public boolean search(int i) {
		if (i >= 0 && i <= MAX) {
			return DATA[i][1];
		} else if (i < 0 && Math.abs(i) <= MAX) {
			return DATA[Math.abs(i)][0];
		} else {
			return false;
		}
	}

}
