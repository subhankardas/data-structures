package dynamic_programming;

import java.util.HashMap;

/**
 * Find the N'th fibonacci term from the fibonacci series. The simple recursive
 * logic works fine for smaller inputs but for larger inputs it becomes very
 * slow and expensive. Using dynamic programming we can optimize the solution
 * and less expensive for larger inputs as well.
 * 
 * In our recursive method when we compute 20th term of fibonacci then fib(3) is
 * called 2584 times and fib(10) is called 89 times. It means that we are
 * computing the 10th term of fibonacci 89 times from scratch. In the ideal
 * world, if we have already computed value of fib(10) once, we should not be
 * recomputing it again. Memoization dynamic programming are techniques used to
 * solve this problem more efficiently. This can be achieved by storing the
 * computed values in an array, and using them later when called.
 * 
 * Time complexity: O(N)
 * 
 * Space complexity: O(N)
 */
public class NthFibonacciTerm {

	// Memo to store N and N'th fibonacci terms respectively
	private static HashMap<Integer, Long> memo = new HashMap<>();

	public static void main(String[] args) {

		System.out.println("Fibonacci 6th term is  : " + fibonacci(6));
		System.out.println("Fibonacci 9th term is  : " + fibonacci(9));
		System.out.println("Fibonacci 50th term is : " + fibonacci(50));

	}

	public static long fibonacci(int nth) {
		// Base case
		if (nth <= 1)
			return nth;

		// Check memo for solved nth answer
		if (memo.containsKey(nth))
			return memo.get(nth);

		// Recurse for next fibonacci term and store to memo
		long nthvalue = fibonacci(nth - 1) + fibonacci(nth - 2);
		memo.put(nth, nthvalue);

		return nthvalue;
	}

}
