package data_structures.segment_tree;

import java.util.Arrays;

/**
 * CONSTRUCTION :
 * 
 * INPUT = [1, 3, 5, 7, 9, 11]
 * 
 * STEP 1: [0, 0, 0, 0, 0, 0, 1, 3, 5, 7, 9, 11]
 * STEP 2: [0, 36[32+4], 32[12+20], 4[1+3], 12[5+7], 20[9+11], 1, 3, 5, 7, 9, 11]
 * 
 * Time Complexities:
 * 
 * Tree construction: O(N)
 * 
 * Query in range: O(log N)
 * 
 * Updating an element: O(log N)
 */
public class EfficientMain {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 7, 9, 11 };
		System.out.println("Input: " + Arrays.toString(arr));

		// Build a new segment tree
		EfficientSegmentTree est = new EfficientSegmentTree(arr);
		est.print();

		// Sum queries for a range
		System.out.println("Sum of range 2 - 4 = " + est.sum(1, 3));
		System.out.println("Sum of range 5 - 6 = " + est.sum(4, 5) + "\n");

		// Update array and segment tree
		est.update(2, 6);
		arr[2] = 6;

		// Print updated segment tree
		System.out.println("Updated: " + Arrays.toString(arr));
		est.print();

		// Sum queries for a range
		System.out.println("Sum of range 2 - 3 = " + est.sum(1, 2));
	}

}
