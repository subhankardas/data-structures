package data_structures.segmenttree;

import java.util.Arrays;

/**
 * Segment Tree is a data structure that allows answering range queries over an
 * array effectively, while still being flexible enough to allow modifying the
 * array.
 * Example of a segment tree to find the sum of ranges in the array [1, 3, 5, 7, 9, 11]
 * The leaf nodes are always the elements of the array.
 * 
 *                       36 [0-5]
 *                      /        \
 *                  9[0-2]        27[3-5]
 *                 /      \       /      \
 *             4[0-1]      5   16[3-4]    11
 *            /      \         /      \
 *           1       3        7        9
 *           
 * The segment tree array = [36, 9, 27, 4, 5, 16, 11, 1, 3, 0, 0, 7, 9, 0, 0]
 * 
 * Time complexity :
 * Construction: O(n)
 * Query a range: O(Logn)
 * Update leaf node: O(Logn)
 */
public class Main {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 7, 9, 11 };
		System.out.println("Input: " + Arrays.toString(arr));

		// Build a new segment tree
		SegmentTree st = new SegmentTree(arr);
		st.print();

		// Sum queries for a range
		System.out.println("Sum of range 2 - 4 = " + st.sum(1, 3));
		System.out.println("Sum of range 5 - 6 = " + st.sum(4, 5) + "\n");

		// Update array and segment tree
		st.update(2, 6);
		arr[2] = 6;

		// Print updated segment tree
		System.out.println("Updated: " + Arrays.toString(arr));
		st.print();

		// Sum queries for a range
		System.out.println("Sum of range 2 - 3 = " + st.sum(1, 2));

	}

}
