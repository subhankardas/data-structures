package data_structures.linked_list;

/**
 * Implementation for Floyd’s Cycle-Finding Algorithm.
 */
public class FloydsCycleFindingAlgorithm {

	static Node head;

	public static void main(String[] args) {
		createListWithLoop();
		detectLoop();
	}

	public static void createListWithLoop() {
		head = new Node(12);
		Node n1 = new Node(23);
		Node n2 = new Node(34);
		Node n3 = new Node(45);
		Node n4 = new Node(56);

		// Create list with a loop
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n1;
	}

	public static void detectLoop() {
		Node slow = head; // Pointer moves one step
		Node fast = head; // Pointer moves two steps

		boolean flag = false;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			// If slow and fast pointer meets i.e. loop exists
			if (slow == fast) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("Loop detected!");
			countNodesInLoop(slow);
		} else
			System.out.println("No loop found.");
	}

	public static void countNodesInLoop(Node slow) {
		Node temp = slow;
		int nodeCount = 0;

		// Traverse from loop start node until returns to same node
		while (temp.next != slow) {
			nodeCount++;
			temp = temp.next;
		}

		System.out.println("No. of nodes in loop: " + nodeCount);
	}

}

class Node {
	int data;
	Node next;

	Node(int dt) {
		data = dt;
		next = null;
	}
}