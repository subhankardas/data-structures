package algorithms.search;

import java.util.Arrays;

public class AdvancedSearchMain {

	public static void main(String[] args) {

		int[] sorted = { 2, 5, 6, 8, 11, 15, 21, 32, 44, 57 };

		FibonacciSearch fibonacciSearch = new FibonacciSearch();

		// Fibonacci search
		System.out.println("FIBONACCI SEARCH -\nInput : " + Arrays.toString(sorted));
		System.out.println("Search 16 : " + fibonacciSearch.find(sorted, 16));
		System.out.println("Search 5  : " + fibonacciSearch.find(sorted, 5));
		System.out.println("Search 32 : " + fibonacciSearch.find(sorted, 32));
		System.out.println("Search 65 : " + fibonacciSearch.find(sorted, 65));

	}

}
