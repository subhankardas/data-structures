package dynamic_programming;

import java.util.HashMap;

public class NthFibonacciTerm {

	private static HashMap<Integer, Long> memo = new HashMap<>();

	public static void main(String[] args) {

		System.out.println("Fibonacci 6th term is  : " + fibonacci(6));
		System.out.println("Fibonacci 9th term is  : " + fibonacci(9));
		System.out.println("Fibonacci 50th term is : " + fibonacci(50));

	}

	public static long fibonacci(int nth) {
		if (nth <= 1)
			return nth;
		if (memo.containsKey(nth))
			return memo.get(nth);

		long nthvalue = fibonacci(nth - 1) + fibonacci(nth - 2);
		memo.put(nth, nthvalue);

		return nthvalue;
	}

}
