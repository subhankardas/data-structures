package data_structures.skip_list;

/**
 * A skip list is a probabilistic data structure. The skip list is used to store
 * a sorted list of elements or data with a linked list. In one single step, it
 * skips several elements of the entire list, which is why it is known as a skip
 * list.
 * 
 * It is built in two layers: The lowest layer (normal lane) and top layer
 * (express lane).
 * 
 * The lowest layer of the skip list is a common sorted linked list, and the top
 * layers of the skip list are like an "express line" where the elements are
 * skipped.
 */
public class SkipList<T> {

	private int size = 0;

	// Normal lane pointers
	public Node head;
	public Node tail;

	// Express lane pointers
	public Node expHead;
	public Node expTail;

	// Steps to skip for express lane
	public int skipSteps;

	public final int MAX_SKIP = 5;
	public final int MIN_SKIP = 3;

	public int scans;

	public class Node {
		public T data;
		public Node next;
		public Node down;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public SkipList() {
		skipSteps = getRandomNumber(MIN_SKIP, MAX_SKIP);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(T elem) {
		// List is empty, add head nodes
		if (isEmpty()) {
			// Add head for normal lane
			Node node = new Node(elem, null);
			head = tail = node;

			// Add head for express lane
			Node expNode = new Node(elem, null);
			expNode.down = tail;
			expHead = expTail = expNode;
		} else {
			// Add next nodes in normal lane
			Node node = new Node(elem, null);
			tail.next = node;
			tail = node;

			// Add next nodes in express lane
			if (size % skipSteps == 0) {
				Node expNode = new Node(elem, null);
				expNode.down = tail;
				expTail.next = expNode;
				expTail = expNode;
			}
		}
		size++;
	}

	// Prints express lane if TRUE else prints normal lane
	public String print(boolean express) {
		StringBuilder str = new StringBuilder();
		Node trav = express ? expHead : head;
		while (trav != null) {
			str.append(" -> " + trav.data);
			trav = trav.next;
		}
		return str.toString();
	}

	public boolean search(T elem) {
		// Scans required to find element
		scans = 0;

		// Start searching from express lane, till element is less than next node value
		Node trav = expHead;
		while (trav != null && trav.next != null) {
			if (trav.data == elem || trav.next.data == elem)
				return true;

			if ((int) elem > (int) trav.data && (int) elem < (int) trav.next.data)
				break;

			trav = trav.next;
			scans++;
		}

		// Proceed searching in normal lane, till element is found
		trav = trav.down;
		while (trav != null) {
			if (trav.data == elem)
				return true;

			trav = trav.next;
			scans++;
		}

		return false;
	}

	// Get a random number
	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

}
