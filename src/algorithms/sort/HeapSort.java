package algorithms.sort;

/**
 * Heap sort is a comparison-based sorting technique based on Binary Heap data
 * structure. It is similar to selection sort where we first find the minimum
 * element and place the minimum element at the beginning. We repeat the same
 * process for the remaining elements.
 * 
 * Heap Sort Algorithm for sorting in increasing order:
 * 
 * 1. Build a max heap from the input data.
 * 
 * 2. At this point, the largest item is stored at the root of the heap. Replace
 * it with the last item of the heap followed by reducing the size of heap by 1.
 * Finally, heapify the root of the tree.
 * 
 * 3. Repeat step 2 while the size of the heap is greater than 1.
 * 
 * Time Complexity: O(N*Log N) [Build = O(N) + Heapify = O(Log N)]
 * 
 * Space Complexity: O(1)
 */
public class HeapSort {

	public int[] sort(int[] arr) {
		int len = arr.length;

		// Build max heap
		for (int currNode = len / 2 - 1; currNode >= 0; currNode--) {
			heapify(arr, len, currNode);
		}

		// Heap sort
		for (int i = len - 1; i >= 0; i--) {
			// Swap largest element to end of array
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Heapify root element
			heapify(arr, i, 0);
		}

		return arr;
	}

	private void heapify(int arr[], int len, int currNode) {
		// Find largest among root, left child and right child
		int largest = currNode;
		int leftNode = 2 * currNode + 1;
		int rightNode = 2 * currNode + 2;

		if (leftNode < len && arr[leftNode] > arr[largest])
			largest = leftNode;

		if (rightNode < len && arr[rightNode] > arr[largest])
			largest = rightNode;

		// Swap and continue heapify if root is not largest
		if (largest != currNode) {
			int swap = arr[currNode];
			arr[currNode] = arr[largest];
			arr[largest] = swap;

			heapify(arr, len, largest);
		}
	}

}