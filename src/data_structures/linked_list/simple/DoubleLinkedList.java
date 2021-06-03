package data_structures.linked_list.simple;

public class DoubleLinkedList<T> {
	private int size = 0;
	public Node head;
	public Node tail;

	public class Node {
		public T data; // Data
		public Node prev; // Pointer to next node
		public Node next; // Pointer to previous node

		public Node(T data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	public void clear() {
		// Traverse to the end of list from head
		Node trav = head;
		while (trav != null) {
			trav.data = null;
			trav.next = trav.prev = null;
			trav = null;
		}

		// Set all pointers and size to zero
		head = tail = trav = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(T elem) {
		// If node is first node, add node, point both head and tail to this node
		if (isEmpty()) {
			Node node = new Node(elem, null, null);
			head = tail = node;
		} else {
			// Else add node, point next to head, previous to null
			// Set current head previous to this node
			Node node = new Node(elem, null, head);
			head.prev = node;
			// Set new head as this node
			head = node;
		}
		size++;
	}

	public void addLast(T elem) {
		// If node is first node, add node, point both head and tail to this node
		if (isEmpty()) {
			Node node = new Node(elem, null, null);
			head = tail = node;
		} else {
			// Else add node, point previous to tail, next to null
			// Set current tail next to this node
			Node node = new Node(elem, tail, null);
			tail.next = node;
			// Set new tail as this node
			tail = node;
		}
		size++;
	}

	public void add(T elem) {
		addLast(elem);
	}

	public T peekFirst() {
		if (isEmpty())
			throw new RuntimeException("Cannot peek empty list.");

		return head.data;
	}

	public T peekLast() {
		if (isEmpty())
			throw new RuntimeException("Cannot peek empty list.");

		return tail.data;
	}

	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException("Cannot remove from empty list.");

		// Get the node to remove i.e head and set new head as its next
		T data = head.data;
		head = head.next;
		size--;

		// If its last node set tail to null, else set last head as null
		if (isEmpty())
			tail = null;
		else
			head.prev = null;

		return data;
	}

	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException("Cannot remove from empty list.");

		// Get node to remove i.e tail and set new tail as its next
		T data = tail.data;
		tail = tail.prev;
		size--;

		// If its last node set head to null, else set tail next as null
		if (isEmpty())
			head = null;
		else
			tail.next = null;

		return data;
	}

	public void remove(T elem) {
		// Traverse list till element is found
		Node trav = head;
		while (trav != null && trav.data != elem) {
			trav = trav.next;
		}

		// If node exists, remove head or tail accordingly, else remove node
		if (trav != null) {
			if (trav == head) {
				head = head.next;
				head.prev = null;
			} else if (trav == tail) {
				tail = tail.prev;
				tail.next = null;
			} else {
				// Get removal node's previous and next nodes
				Node prev = trav.prev;
				Node next = trav.next;

				// Set removal node to null
				prev.next = null;

				// Set previous node next to next and next node previous to previous
				prev.next = next;
				next.prev = prev;
			}
		}
	}

	public void removeAt(int idx) {
		int index = 0;
		Node trav = head;

		// Traverse list till index is matched
		while (trav != null && index != idx) {
			trav = trav.next;
			index++;
		}

		// Remove the existing node accordingly
		if (trav != null) {
			if (trav == head) {
				head = head.next;
				head.prev = null;
			} else if (trav == tail) {
				tail = tail.prev;
				tail.next = null;
			} else {
				Node prev = trav.prev;
				Node next = trav.next;

				prev.next = null;

				prev.next = next;
				next.prev = prev;
			}
		}
	}

	public int indexOf(T elem) {
		int idx = 0;
		Node trav = head;

		// Traverse list till element is found, return the index else continue
		while (trav != null) {
			if (trav.data == elem)
				return idx;
			else
				trav = trav.next;

			idx++;
		}

		return -1;
	}

	/*
	 * Reverse single linked list i.e. using only next pointer of nodes.
	 */
	public void reverse() {
		if (head == null)
			return;

		Node prev = null;
		Node curr = head;
		Node next = null;

		while (curr != null) {
			next = curr.next; // Store next
			curr.next = prev; // Set current next to previous i.e. reverse link
			prev = curr; // Set this as previous for next iteration
			curr = next; // Now update current for next iteration
		}

		this.head = prev; // Finally update head with the last visited node in list
	}

	/*
	 * Reverse doubly linked list i.e. using both previous and next node pointer.
	 */
	public void reverseDoublyLinkedList() {
		if (head == null)
			return;

		Node current = head;
		Node temp = null;

		while (current != null) {
			// Swap previous and next node pointers for current node
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;

			// Set current node for next iteration
			current = current.prev;
		}

		// Set new head if list is not empty
		if (temp != null) {
			head = temp.prev;
		}
	}

	public boolean contains(T elem) {
		return indexOf(elem) != -1;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		Node trav = head;
		while (trav != null) {
			str.append(" -> " + trav.data);
			trav = trav.next;
		}

		return str.toString();
	}

}
