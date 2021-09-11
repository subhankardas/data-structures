package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Given an array of integers and a target return any possible
 * combinations of numbers from the array that can be used to generate the
 * target. The values can be repeated any number of times.
 * 
 * Solution: Same as the can sum implementation.
 * 
 * Time complexity: O(M*N) [ M = Target sum, N = Array length ]
 * 
 * Space complexity: O(M) [ M = Target sum ]
 */
public class HowSum {

	public static void main(String[] args) {

		System.out.println(canSum(7, new int[] { 2, 3 }));
		System.out.println(canSum(7, new int[] { 5, 3, 4, 7 }));
		System.out.println(canSum(7, new int[] { 2, 4 }));
		System.out.println(canSum(8, new int[] { 2, 3, 5 }));
		System.out.println(canSum(300, new int[] { 7, 14 }));

	}

	public static List<Integer> canSum(int target, int[] nums) {
		return howSum(target, nums, new HashMap<>());
	}

	public static List<Integer> howSum(int target, int[] nums, Map<Integer, List<Integer>> memo) {
		// Base case i.e. possible to generate target sum using numbers
		if (target == 0)
			return new ArrayList<>();

		// Base case i.e. not possible to generate target sum
		if (target < 0)
			return null;

		// Check if solution of current target sum exists in memo
		if (memo.containsKey(target))
			return memo.get(target);

		// Recursive call selecting all numbers from array
		for (int num : nums) {
			int remainder = target - num; // Subtract number from target
			List<Integer> result = howSum(remainder, nums, memo); // Result for the remain

			// Result indicates its possible to generate target further
			if (result != null) {
				result.add(num);
				memo.put(target, result);

				return result;
			}
		}

		// All choices exhausted, no possible solution, return false
		memo.put(target, null);
		return null;
	}

}
