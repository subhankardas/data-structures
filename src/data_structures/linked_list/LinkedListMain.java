package data_structures.linked_list;

public class LinkedListMain {

	public static void main(String[] args) {
		doubleLinkedListImpl();
		singleLinkedListOperations();
		doubleLinkedListOperations();
	}

	public static void doubleLinkedListImpl() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

		list.add(2);
		list.add(3);
		list.add(4);

		System.out.println("L:" + list);

		list.addFirst(1);
		list.addLast(5);

		System.out.println("L:" + list);

		System.out.println("F: " + list.peekFirst() + "  L: " + list.peekLast());

		list.addFirst(123);
		list.addLast(456);

		System.out.println("L:" + list);

		list.removeFirst();
		list.removeLast();

		System.out.println("L:" + list);

		list.remove(4);

		System.out.println("L:" + list);

		list.removeAt(3);

		System.out.println("L:" + list);

		System.out.println("C: " + list.contains(2));

		System.out.println("E: " + list.isEmpty());

		list.clear();

		System.out.println("E: " + list.isEmpty() + "\n");
	}

	public static void singleLinkedListOperations() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		System.out.println("L: " + list);

		list.reverse();
		System.out.println("L: " + list + "\n");
	}

	public static void doubleLinkedListOperations() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		System.out.println("L: " + list);

		list.reverseDoublyLinkedList();
		System.out.println("L: " + list);
	}
}
