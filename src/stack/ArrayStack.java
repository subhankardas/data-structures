package stack;

import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class ArrayStack<T> {

	private static final int DEFAULT_SIZE = 3;

	private T[] arr;
	private int top;

	public ArrayStack() {
		this(DEFAULT_SIZE);
	}

	public ArrayStack(int size) {
		// Create a new array
		arr = (T[]) new Object[size];
		top = -1;
	}

	public int size() {
		return top;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(T elem) {
		// If array is full, throw stack overflow exception
		if (top == arr.length - 1)
			throw new StackOverflowError();

		// Increment the current top, add element to top
		top++;
		arr[top] = elem;
	}

	public void pop() {
		if (isEmpty())
			throw new EmptyStackException();

		// Pop from the top of the array, decrement the current top
		arr[top] = null;
		top--;
	}

	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();

		// Peek at the top element of the array
		return arr[top];
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i <= top; i++) {
			str.append(arr[i] + "  ");
		}
		return str.toString();
	}

}
