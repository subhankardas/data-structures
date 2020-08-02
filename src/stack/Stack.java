package stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<T> {

	LinkedList<T> list;

	public Stack() {
		// Create a new list
		list = new LinkedList<>();
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void push(T elem) {
		// Push to the last of list
		list.addLast(elem);
	}

	public void pop() {
		if (isEmpty())
			throw new EmptyStackException();

		// Pop from the last of the list
		list.removeLast();
	}

	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();

		// Peek at the last of list
		return list.peekLast();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (T elem : list) {
			str.append(elem + "  ");
		}
		return str.toString();
	}

}
