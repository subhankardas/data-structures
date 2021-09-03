package dynamic_programming;

import java.util.HashMap;

/**
 * Grid traveler problem: Given a grid of M rows and N columns, calculate the
 * no. of paths a traveler can move from the top-left corner to the bottom-right
 * corner to end his journey. The traveler can only move in two directions i.e.
 * right or down.
 * 
 * Solution: Starting with a grid of M x N size, lets say the traveler moved
 * right now since he cannot go left the effective grid size becomes M x N-1.
 * Similarly if he moved down the effective grid size for the next move would
 * become M-1 x N. Proceeding in this way the traveler can decide to move right
 * or down from the current position with the remaining grid until he has a grid
 * size of 1x1 where he has already reached the end point or 0x0 which is not a
 * possible path. Now the total no. of paths will be the sum of possible ways to
 * reach from M x N grid to 1x1 grid ignoring all the paths leading to 0x0.
 * 
 * Memoized solution will require us to store the effective grid size along with
 * all possible no. of paths which will represent an overlapping sub-solution.
 * 
 * Time complexity: O(M*N)
 * 
 * Space complexity: O(M+N)
 */
public class GridTraveler {

	private static HashMap<String, Long> memo = new HashMap<>();

	public static void main(String[] args) {

		System.out.println(gridTraveler(1, 1));
		System.out.println(gridTraveler(2, 3));
		System.out.println(gridTraveler(3, 2));
		System.out.println(gridTraveler(3, 3));
		System.out.println(gridTraveler(18, 18));

	}

	public static long gridTraveler(int m, int n) {
		// Key to identify effective grid size i.e. M-N
		final String key = m + "-" + n;

		// Base case i.e. traveler has reached end point
		if (m == 1 && n == 1)
			return 1;

		// Base case i.e. invalid path
		if (m == 0 || n == 0)
			return 0;

		// Check if solution for this subproblem exists in memo
		if (memo.containsKey(key))
			return memo.get(key);

		// Calculate solution i.e sum of paths going down and going right
		long result = gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
		memo.put(key, result);

		return result;
	}

}
