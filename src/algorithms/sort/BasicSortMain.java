package algorithms.sort;

import java.util.Arrays;

public class BasicSortMain {

	public static void main(String[] args) {

		int[] arr1 = { 3, 1, 7, 5, 4, 2, 6, 8 };
		int[] arr2 = { 3, 1, 7, 5, 4, 2, 6, 8 };
		int[] arr3 = { 3, 1, 7, 5, 4, 2, 6, 8 };
		int[] arr4 = { 3, 1, 7, 5, 4, 2, 6, 8 };

		System.out.println("UNSORTED ARRAY  : " + Arrays.toString(arr1) + "\n");

		System.out.println("BUBBLE SORT     : " + Arrays.toString(new BubbleSort().sort(arr1)));
		System.out.println("SELECTION SORT  : " + Arrays.toString(new SelectionSort().sort(arr2)));
		System.out.println("INSERTION SORT  : " + Arrays.toString(new InsertionSort().sort(arr3)));
		System.out.println("MERGE SORT      : " + Arrays.toString(new MergeSort().sort(arr4)));

	}

}
