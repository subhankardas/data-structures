package problems.gfg;

import data_structures.linked_list.simple.DoubleLinkedList;
import data_structures.linked_list.simple.DoubleLinkedList.Node;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class LinkedListReverse {

	public static DoubleLinkedList<Integer> list;

	public static void main(String[] args) {

		init();
		print();
		reverse();
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

	public static void reverse() {
		// Base cases
		if (list == null || list.head == null || list.head.next == null)
			return;

		// Current and previous nodes
		Node curr = list.head;
		Node prev = null;

		while (curr != null) {
			// Store next node for traversal, point current node to previous
			Node temp = curr.next;
			curr.next = prev;

			// Set current node as previous and current node for next loop
			prev = curr;
			curr = temp;
		}

		// Reversed list now point from end of list
		list.head = prev;
	}

}
