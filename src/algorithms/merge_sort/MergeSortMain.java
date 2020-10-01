package algorithms.merge_sort;

import java.util.Arrays;

public class MergeSortMain {

	public static void main(String[] args) {

		int[] arr = { 3, 1, 7, 5, 4, 2, 6 };

		System.out.println("Unsorted: " + Arrays.toString(arr));

		arr = new MergeSort().sort(arr);

		System.out.println("Sorted:   " + Arrays.toString(arr));

	}

}
