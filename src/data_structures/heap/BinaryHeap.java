package data_structures.heap;

/**
 * MAX HEAP: This is a kind of almost complete binary tree where all the parent
 * node must contain value greater than or equal to both of its children nodes.
 * Removal of all elements from root gives us array in descending sorted order.
 *
 * MIN HEAP: This is a kind of almost complete binary tree where all the parent
 * node must contain value lesser than or equal to both of its children nodes.
 * Removal of all elements from root gives us array in ascending sorted order.
 * 
 * Max. Heap implementation can be converted into Min. Heap by just reversing
 * the order of node comparisons.
 * 
 * Heaps are tree structures and can be easily represented by arrays.
 * 
 * Build a Max. Heap tree in O(n)
 * 
 * Extract Max. k times to get k maximum elements from the Max. Heap O(k log n)
 * 
 * K'th largest(or smallest) elements in an array = O(n + k log n)
 * 
 * Heap is used to implement priority queue.
 */
public class BinaryHeap {

	private static final int d = 2; // Binary Heap

	private int[] heap;
	private int size;

	public BinaryHeap(int capacity) {
		size = 0;
		heap = new int[capacity];
	}

	/**
	 * Insertion is always done on the leaf node, then compared with the parent node
	 * and if it invalids the max. heap condition, node is swapped up with parent.
	 * The same is repeated for that parent position since it now contains the
	 * inserted value. So from the leaf node level max. swapping may occur on all
	 * parent node levels i.e. the height of the tree = O(log N)
	 * 
	 * Complexity: O(log N)
	 */
	public void insert(int x) {
		if (isFull())
			throw new RuntimeException("Heap is full.");

		// Add new element to leftmost leaf node i.e. end of array
		heap[size++] = x;

		// Heapify up from the new node index
		heapifyUp(size - 1);
	}

	/**
	 * Removal occurs on the given index and then the blank node is filled with the
	 * leaf node value, leaf node is removed. Then the node in the removed position
	 * is swapped down with its largest child value if it invalids the max. heap
	 * condition. The same is repeated for largest child position since it now
	 * contains the leaf node value. So from removed node index max. swapping may
	 * occur on all children node level i.e. height of the tree = O(log N)
	 * 
	 * Complexity: O(log N)
	 */
	public int delete(int x) {
		if (isEmpty())
			throw new RuntimeException("Heap is empty.");

		// Remove the element from given index
		int key = heap[x];

		// Move last leaf node to removed position and remove it
		heap[x] = heap[size - 1];
		size--;

		// Heapify down from the removed index
		heapifyDown(x);

		return key;
	}

	private void heapifyUp(int i) {
		// If current node is greater than parent, swap with parent
		if (i > 0 && heap[i] > heap[parent(i)]) {
			swap(i, parent(i));

			// Repeat the same for parent node
			heapifyUp(parent(i));
		}
	}

	private void heapifyDown(int i) {
		int left = left(i);
		int right = right(i);

		int largest = i;

		// If left child is greater than current node, largest is left child
		if (left < size && heap[left] > heap[i]) {
			largest = left;
		}

		// If right child is greater than largest node, largest is right child
		if (right < size && heap[right] > heap[largest]) {
			largest = right;
		}

		// If current node is not largest node, swap with the largest
		if (largest != i) {
			swap(i, largest);

			// Repeat same for the largest index, which now has current node value
			heapifyDown(largest);
		}
	}

	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == heap.length;
	}

	private int parent(int i) {
		return (i - 1) / d;
	}

	private int left(int i) {
		return (d * i + 1);
	}

	private int right(int i) {
		return (d * i + 2);
	}

	public void printHeap() {
		System.out.print("Heap = ");
		for (int i = 0; i < size; i++)
			System.out.print(heap[i] + " ");
		System.out.println();
	}

	public int size() {
		return size;
	}
}
