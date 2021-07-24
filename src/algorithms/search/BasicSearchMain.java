package algorithms.search;

import java.util.Arrays;

public class BasicSearchMain {

	public static void main(String[] args) {

		int[] sorted = { 2, 5, 6, 8, 11, 15, 21, 32, 44, 57 };

		BinarySearch binarySearch = new BinarySearch();
		JumpSearch jumpSearch = new JumpSearch();
		InterpolationSearch interpolationSearch = new InterpolationSearch();
		ExponentialSearch exponentialSearch = new ExponentialSearch();

		// Binary search
		System.out.println("BINARY SEARCH -\nInput : " + Arrays.toString(sorted));
		System.out.println("Search 16 : " + binarySearch.find(sorted, 16));
		System.out.println("Search 5  : " + binarySearch.find(sorted, 5));
		System.out.println("Search 32 : " + binarySearch.find(sorted, 32));
		System.out.println("Search 65 : " + binarySearch.find(sorted, 65));

		// Jump search
		System.out.println("\nJUMP SEARCH -\nInput : " + Arrays.toString(sorted));
		System.out.println("Search 16 : " + jumpSearch.find(sorted, 16));
		System.out.println("Search 5  : " + jumpSearch.find(sorted, 5));
		System.out.println("Search 32 : " + jumpSearch.find(sorted, 32));
		System.out.println("Search 65 : " + jumpSearch.find(sorted, 65));

		// Interpolation search
		System.out.println("\nINTERPOLATION SEARCH -\nInput : " + Arrays.toString(sorted));
		System.out.println("Search 16 : " + interpolationSearch.find(sorted, 16));
		System.out.println("Search 5  : " + interpolationSearch.find(sorted, 5));
		System.out.println("Search 32 : " + interpolationSearch.find(sorted, 32));
		System.out.println("Search 65 : " + interpolationSearch.find(sorted, 65));

		// Exponential search
		System.out.println("\nEXPONENTIAL SEARCH -\nInput : " + Arrays.toString(sorted));
		System.out.println("Search 16 : " + exponentialSearch.find(sorted, 16));
		System.out.println("Search 5  : " + exponentialSearch.find(sorted, 5));
		System.out.println("Search 32 : " + exponentialSearch.find(sorted, 32));
		System.out.println("Search 65 : " + exponentialSearch.find(sorted, 65));

	}

}
