package queue;

public class QueueMain {

	public static void main(String[] args) {

		Queue<String> queue = new Queue<>();

		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		System.out.println("Q: " + queue);

		System.out.println("D: " + queue.dequeue());

		System.out.println("Q: " + queue);

		System.out.println("D: " + queue.dequeue());

		queue.enqueue("D");

		System.out.println("Q: " + queue);

		System.out.println("D: " + queue.dequeue());

		System.out.println("Q: " + queue);

		System.out.println("D: " + queue.dequeue());

		System.out.println("Q: " + queue);

		System.out.println("S: " + queue.size());

		queue.enqueue("X");

		System.out.println("Q: " + queue);

		System.out.println("D: " + queue.dequeue());

		System.out.println("Q: " + queue);

	}

}
