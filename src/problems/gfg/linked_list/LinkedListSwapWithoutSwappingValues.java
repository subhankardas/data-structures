package problems.gfg.linked_list;

import data_structures.linked_list.simple.DoubleLinkedList;
import data_structures.linked_list.simple.DoubleLinkedList.Node;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class LinkedListSwapWithoutSwappingValues {

	public static DoubleLinkedList<Integer> list;

	public static void main(String[] args) {

		init();
		print();
		swap(2, 3);
		print();
		swap(1, 4);
		print();
		swap(4, 5);
		print();
		swap(12, 4);
		print();

	}

	public static void init() {
		list = new DoubleLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
	}

	public static void print() {
		System.out.println(list);
	}

	public static void swap(int n1, int n2) {
		Node head = list.head;
		Node curr = head, prev = null; // Current and previous node

		// Node for n1 and n2, previous nodes for node1 and node2
		Node prevNode1 = null, prevNode2 = null;
		Node node1 = null, node2 = null;

		// Base cases
		if (head == null || n1 == n2) {
			return;
		}

		// Traverse the list
		while (curr != null) {
			// Found n1, set previous and node 1
			if ((int) curr.data == n1) {
				prevNode1 = prev;
				node1 = curr;
			} else if ((int) curr.data == n2) {
				// Found n2, set previous and node 2
				prevNode2 = prev;
				node2 = curr;
			}

			// Ready to swap nodes
			if (node1 != null && node2 != null) {
				// Swap previous node
				if (prevNode1 == null)
					list.head = node2;
				else
					prevNode1.next = node2;

				if (prevNode2 == null)
					list.head = node1;
				else
					prevNode2.next = node1;

				// Swap the n1 and n2 nodes
				Node temp = node1.next;
				node1.next = node2.next;
				node2.next = temp;

				return;
			}
			prev = curr;
			curr = curr.next;
		}

		System.out.println("Unable to swap, invalid input.");
	}

}
