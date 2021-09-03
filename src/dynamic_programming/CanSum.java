package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Display if it is possible to generate a target sum from a given
 * array of numbers. Same number from the array can be used multiple times. The
 * recursive approach would call the function canSum() with the remainder i.e.
 * target-number i.e. all values from the array and return true if target
 * becomes zero hence possible to generate target or false if target becomes
 * negative.
 * 
 * Using memoization we have optimized the solution by storing the unique target
 * values as key and computed solution for that target as value in the memo.
 * This will take care for the overlapping sub-solution property of the
 * solution.
 * 
 * Time complexity: O(M*N) [ M = Target sum, N = Array length ]
 * 
 * Space complexity: O(M) [ M = Target sum ]
 */
public class CanSum {

	public static void main(String[] args) {

		System.out.println(canSum(7, new int[] { 2, 3 }));
		System.out.println(canSum(7, new int[] { 5, 3, 4, 7 }));
		System.out.println(canSum(7, new int[] { 2, 4 }));
		System.out.println(canSum(8, new int[] { 2, 3, 5 }));
		System.out.println(canSum(300, new int[] { 7, 14 }));

	}

	public static boolean canSum(int target, int[] nums) {
		return canSum(target, nums, new HashMap<>());
	}

	public static boolean canSum(int target, int[] nums, Map<Integer, Boolean> memo) {
		// Base case i.e. possible to generate target sum using numbers
		if (target == 0)
			return true;

		// Base case i.e. not possible to generate target sum
		if (target < 0)
			return false;

		// Check if solution of current target sum exists in memo
		if (memo.containsKey(target))
			return memo.get(target);

		// Recursive call selecting all numbers from array
		for (int num : nums) {
			int remainder = target - num; // Subtract number from target
			if (canSum(remainder, nums, memo)) {
				memo.put(target, true);
				return true;
			}
		}

		// All choices exhausted, no possible solution, return false
		memo.put(target, false);
		return false;
	}

}
