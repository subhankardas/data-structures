package algorithms.sort;

import java.util.Arrays;

public class AdvancedSortMain {

	public static void main(String[] args) {

		int[] arr1 = { 3, 1, 7, 5, 4, 2, 6, 8 };
		int[] arr2 = { 3, 1, 7, 5, 4, 2, 6, 8 };

		System.out.println("UNSORTED ARRAY  : " + Arrays.toString(arr1) + "\n");

		System.out.println("HEAP SORT       : " + Arrays.toString(new HeapSort().sort(arr1)));
		System.out.println("MERGE SORT      : " + Arrays.toString(new MergeSort().sort(arr2)));

	}

}
