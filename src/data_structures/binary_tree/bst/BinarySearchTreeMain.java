package data_structures.binary_tree.bst;

import java.util.Stack;

public class BinarySearchTreeMain {

	static BinarySearchTree bst;
	static Node root;

	static Stack<Integer> stk;

	public static void main(String[] args) {
		bst = new BinarySearchTree();

		insert(10);
		insert(5);
		insert(23);
		insert(1);
		insert(12);
		insert(6);
		insert(7);

		System.out.print("Inorder Traversal of BST: ");
		bst.inorderDFS(root);
		System.out.println();

		stk = new Stack<>();
		System.out.print("Sorted Array: ");

		sort(root);
		System.out.println(stk);

		System.out.println();
		System.out.println("Searching:");
		search();
	}

	public static void insert(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			bst.insert(root, value);
		}
	}

	/**
	 * Inorder DFS traversal of the BST will give us the stored elements in a sorted
	 * order due to the property of BST i.e. the left subtree has nodes lesser than
	 * the current node and right subtree will always have nodes greater than
	 * current. Hence we can achieve faster sorting as well as faster searching.
	 */
	public static void sort(Node node) {
		if (node.left != null) {
			// Traverse to current node's left child
			sort(node.left);
		}

		// Read current node value
		stk.push(node.value);

		if (node.right != null) {
			// Traverse to current node's right child
			sort(node.right);
		}
	}

	public static void search() {
		System.out.println("7: " + bst.search(root, 7));
		System.out.println("9: " + bst.search(root, 9));
		System.out.println("15: " + bst.search(root, 15));
		System.out.println("1: " + bst.search(root, 1));
	}
	
}
