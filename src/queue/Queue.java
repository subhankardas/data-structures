package queue;

@SuppressWarnings("unchecked")
public class Queue<T> {

	private static final int DEFAULT_SIZE = 3;

	private T[] arr;
	private int size;
	private int front;
	private int end;

	public Queue() {
		this(DEFAULT_SIZE);
	}

	public Queue(int size) {
		// Create a new array
		this.size = size + 1;
		arr = (T[]) new Object[this.size];
		front = end = 0;
	}

	public int size() {
		if (end < front)
			return (end + size) - front;
		else
			return end - front;
	}

	public boolean isEmpty() {
		return front == end;
	}

	public void enqueue(T elem) {
		// Add new element at end, increment end ahead
		arr[end] = elem;
		end++;

		// Place end at starting of array
		if (end == size)
			end = 0;
		
		// If end and front overlaps i.e queue is now full
		if (end == front)
			throw new RuntimeException("Queue size not enough.");
	}

	public T dequeue() {
		// Remove the front element, increment front ahead
		T elem = arr[front];
		front++;

		// Front is at end, place front at starting of array
		if (front == size)
			front = 0;

		return elem;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		int e = (end < front) ? (end + size) : end;
		for (int i = front; i < e; i++)
			str.append(arr[i] + "  ");

		return str.toString();
	}

}
