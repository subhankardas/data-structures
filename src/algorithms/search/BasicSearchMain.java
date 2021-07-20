package algorithms.search;

import java.util.Arrays;

public class BasicSearchMain {

	public static void main(String[] args) {

		int[] sorted = { 2, 5, 6, 8, 11, 15, 21, 32, 44, 57 };

		BinarySearch binarySearch = new BinarySearch();

		// Binary search
		System.out.println("Input : " + Arrays.toString(sorted));
		System.out.println("Search 16 : " + binarySearch.find(sorted, 16));
		System.out.println("Search 5  : " + binarySearch.find(sorted, 5));
		System.out.println("Search 32 : " + binarySearch.find(sorted, 32));

	}

}
