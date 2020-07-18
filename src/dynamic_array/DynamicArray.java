package dynamic_array;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class DynamicArray<T> {

	private final static int INITIAL_SIZE = 4;
	private final static int GROW_SIZE = 3;

	private T[] arr;
	private int len;
	private int capacity;

	public DynamicArray() {
		this(INITIAL_SIZE);
	}

	// Create dynamic array using static array
	public DynamicArray(int size) {
		if (size < 0)
			throw new IllegalArgumentException("Array size must be greater than zero.");

		arr = (T[]) new Object[size];
		len = 0;
		capacity = size;
	}

	public int length() {
		return len;
	}

	public boolean isEmpty() {
		return len == 0;
	}

	public T get(int index) {
		if (index < 0)
			throw new IllegalArgumentException("Index must be greater than zero.");
		if (index >= len)
			throw new ArrayIndexOutOfBoundsException();

		return arr[index];
	}

	public void set(int index, T elem) {
		if (index < 0)
			throw new IllegalArgumentException("Index must be greater than zero.");
		if (index >= len)
			throw new ArrayIndexOutOfBoundsException();

		arr[index] = elem;
	}

	public void clear() {
		for (int i = 0; i < len; i++) {
			arr[i] = null;
		}
		len = 0;
	}

	// Add element to end of array
	public void add(T elem) {
		// If array is full, create a new array and copy existing elements
		if (len == capacity) {
			T[] temp = (T[]) new Object[capacity + GROW_SIZE];

			for (int i = 0; i < len; i++)
				temp[i] = arr[i];

			arr = temp;
		}

		// Add element to end of array
		arr[len++] = elem;
	}

	// Remove element at a specific index
	public void removeAt(int index) {
		if (index < 0)
			throw new IllegalArgumentException("Index must be greater than zero.");
		if (index >= len)
			throw new ArrayIndexOutOfBoundsException();

		for (int i = index; i < len - 1; i++) {
			arr[i] = arr[i + 1];
		}

		arr[len - 1] = null;
		len--;
	}

	// Get index of an element
	public int indexOf(T elem) {
		for (int i = 0; i < len; i++) {
			if (arr[i].equals(elem))
				return i;
		}
		return -1;
	}

	// Remove an element from array
	public void remove(T elem) {
		int idx = indexOf(elem);

		// If element exists, remove at found index
		if (idx != -1)
			removeAt(idx);
	}

	// Check if element exists in array
	public boolean contains(T elem) {
		return indexOf(elem) != -1;
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

}
