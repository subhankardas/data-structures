package data_structures.binary_tree.bst;

public class BinarySearchTree {

	Node root;

	public Node insert(Node n, int value) {
		if (n == null) {
			return new Node(value);
		}

		// If value is lesser than node value, add to left node else add to right node
		if (value < n.value) {
			n.left = insert(n.left, value);
		} else if (value > n.value) {
			n.right = insert(n.right, value);
		}

		return n;
	}

	public void inorderDFS(Node node) {
		if (node.left != null) {
			// Traverse to current node's left child
			inorderDFS(node.left);
		}

		// Read current node value
		System.out.print(node.value + " ");

		if (node.right != null) {
			// Traverse to current node's right child
			inorderDFS(node.right);
		}
	}

	public boolean search(Node root, int value) {
		return searchNode(root, value) != null ? true : false;
	}

	private Node searchNode(Node node, int value) {
		/**
		 * If current node has value return this, if value is lesser than current node
		 * search left nodes else right nodes. This approach is equivalent to the binary
		 * search algorithm.
		 */
		if (node == null || node.value == value) {
			return node;
		} else if (value < node.value) {
			return searchNode(node.left, value);
		} else {
			return searchNode(node.right, value);
		}
	}
	
}

class Node {
	int value;
	Node left;
	Node right;

	public Node(int val) {
		value = val;
	}
}