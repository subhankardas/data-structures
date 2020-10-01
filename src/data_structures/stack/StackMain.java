package data_structures.stack;

public class StackMain {

	public static void main(String[] args) {

//		Stack<String> stack = new Stack<>(); // Stack using linked list
		ArrayStack<String> stack = new ArrayStack<>(); // Stack using array

		stack.push("A");
		stack.push("B");
		stack.push("C");

		System.out.println("S: " + stack);

		stack.pop();

		System.out.println("S: " + stack);

		System.out.println("P: " + stack.peek());

		stack.pop();
		stack.pop();

		System.out.println("S: " + stack);
		System.out.println("E: " + stack.isEmpty());

	}

}
