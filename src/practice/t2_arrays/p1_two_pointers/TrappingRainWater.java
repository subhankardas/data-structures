package practice.t2_arrays.p1_two_pointers;

/**
 * Problem Statement:
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 }));
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left]; // Current water = Left Max - Current Height

                left++; // Move left pointer
            } else {
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right]; // Current water = Right Max - Current Height

                right--; // Move right pointer
            }
        }

        return waterTrapped;
    }

}