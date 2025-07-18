package practice.t2_arrays.p1_two_pointers;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        System.out.println(longestHarmoniousSubsequence(new int[] { 1, 3, 2, 2, 5, 4, 3, 2 }));
        System.out.println(longestHarmoniousSubsequence(new int[] { 1, 2, 3, 4 }));
        System.out.println(longestHarmoniousSubsequence(new int[] { 1, 1, 1, 1 }));
        System.out.println(longestHarmoniousSubsequence(new int[] { 1, 2, 2, 3, 3, 4 }));
        System.out.println(longestHarmoniousSubsequence(new int[] { 5, 5, 5, 5 }));
    }

    public static int longestHarmoniousSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) { // Count frequency of each number
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        for (var entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            if (frequencyMap.containsKey(num + 1)) { // Check if the next consecutive number exists
                int currentLength = entry.getValue() + frequencyMap.get(num + 1); // Len. of harmonious subsequence =
                                                                                  // freq. of num + freq. of num + 1
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
