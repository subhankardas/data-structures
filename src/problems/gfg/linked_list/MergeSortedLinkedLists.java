package problems.gfg.linked_list;

import data_structures.linked_list.simple.DoubleLinkedList;
import data_structures.linked_list.simple.DoubleLinkedList.Node;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MergeSortedLinkedLists {

	public static DoubleLinkedList<Integer> list1;
	public static DoubleLinkedList<Integer> list2;

	public static void main(String[] args) {

		init();

		// Print sorted linked lists
		System.out.print("List 1:");
		print1();
		System.out.print("List 2:");
		print2();

		// Perform merge operation
		list1.head = merge();

		// Print merged sorted linked list
		System.out.print("Merged List:");
		print1();

	}

	public static Node merge() {
		Node node1 = list1.head; // Pointer to current node in list 1
		Node node2 = list2.head; // Pointer to current node in list 2

		Node prev = null; // Head for merged list
		Node head = null; // Previous traversed node for merged list

		// If none the pointers have reached to the end of the lists
		while (node1 != null && node2 != null) {
			int n1 = (int) node1.data;
			int n2 = (int) node2.data;

			// List 1 has minimum value
			if (n1 < n2) {
				// Add the head node else link to the previous node
				if (head == null)
					head = node1;
				else
					prev.next = node1;

				// Set new previous node
				prev = node1;

				if (node1 != null)
					node1 = node1.next;
			} else {
				// Add the head node else link to the previous node
				if (head == null)
					head = node2;
				else
					prev.next = node2;

				// Set new previous node
				prev = node2;

				if (node2 != null)
					node2 = node2.next;
			}
		}

		// Add non-exhausted list to the end of merged list
		if (node1 == null)
			prev.next = node2;
		else
			prev.next = node1;

		return head;
	}

	public static void init() {
		list1 = new DoubleLinkedList<>();
		list2 = new DoubleLinkedList<>();

		list1.add(2);
		list1.add(3);
		list1.add(6);
		list1.add(8);

		list2.add(1);
		list2.add(4);
		list2.add(5);
		list2.add(7);
		list2.add(9);
		list2.add(10);
	}

	public static void print1() {
		System.out.println(list1 + "\n");
	}

	public static void print2() {
		System.out.println(list2 + "\n");
	}

}
