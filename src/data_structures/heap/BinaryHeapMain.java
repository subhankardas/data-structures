package data_structures.heap;

public class BinaryHeapMain {

	public static void main(String[] args) {
		
		BinaryHeap maxHeap = new BinaryHeap(10);

		// Inserting elements to the max. heap
		maxHeap.insert(3);
		maxHeap.insert(1);
		maxHeap.insert(8);
		maxHeap.insert(13);
		maxHeap.insert(5);
		maxHeap.insert(25);

		maxHeap.printHeap();

		// Sorting : Remove all elements from heap root position
		System.out.print("Sorted = ");
		int elems = maxHeap.size();
		for (int i = 0; i < elems; i++) {
			System.out.print(maxHeap.delete(0) + " ");
		}
		System.out.println();

	}

}
