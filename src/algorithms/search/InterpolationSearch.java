package algorithms.search;

/**
 * Interpolation Search is an improvement over Binary Search for instances,
 * where the values in a sorted array are uniformly distributed. Binary Search
 * always goes to the middle element to check. On the other hand, interpolation
 * search may go to different locations according to the value of the key being
 * searched. For example, if the value of the key is closer to the last element,
 * interpolation search is likely to start search toward the end side. Let's
 * assume that the elements of the array are linearly distributed.
 * 
 * General equation of line : y = m*x + c [ y is the value in the array and x is
 * its index ]
 * 
 * Now putting value of low, high and x in the equation
 * 
 * arr[high] = m*high + c ----(1)
 * 
 * arr[low] = m*low + c ----(2)
 * 
 * x = m*pos + c ----(3)
 * 
 * m = (arr[high] - arr[low]) / (high - low)
 * 
 * Subtracting equation (2) from (3)
 * 
 * x - arr[low] = m * (pos - low)
 * 
 * pos = low + (x - arr[low]) * (high - low) / (arr[high] - arr[low])
 */
public class InterpolationSearch {

	public int find(int[] arr, int val) {
		return find(arr, val, 0, arr.length - 1);
	}

	public int find(int[] arr, int val, int start, int end) {
		// Estimated position for the searched value
		int pos = (int) (start + (((double) (end - start) / (arr[end] - arr[start])) * (val - arr[start])));

		// Value not in range of array elements
		if (val < arr[start] || val > arr[end])
			return -1;

		// Value in exact range positions
		if (val == arr[start])
			return start;
		if (val == arr[end])
			return end;

		// If estimated position value less than value, search right half or left half
		if (arr[pos] < val)
			return find(arr, val, pos + 1, end);
		else
			return find(arr, val, start, pos - 1);
	}

}
