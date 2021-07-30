package algorithms.sort;

import java.util.Arrays;

public class BasicSortMain {

	public static void main(String[] args) {

		int[] arr = { 3, 1, 7, 5, 4, 2, 6, 8 };

		System.out.println("UNSORTED ARRAY  : " + Arrays.toString(arr) + "\n");

		System.out.println("BUBBLE SORT     : " + Arrays.toString(new BubbleSort().sort(arr)));
		System.out.println("MERGE SORT      : " + Arrays.toString(new MergeSort().sort(arr)));

	}

}
