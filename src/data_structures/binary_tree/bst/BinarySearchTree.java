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

	/**
	 * Removal of node can occur in three possible ways,
	 * 
	 * 1. Node is leaf node: Simply remove the node.
	 * 
	 * 2. Node has one child node: Copy child node value to the node and remove the
	 * child node.
	 * 
	 * 3. Node has two children nodes: Find the minimum node value in right subtree,
	 * copy that value to the node, remove the minimum value node i.e the inorder
	 * successor.
	 */
	public Node remove(Node node, int value) {
		if (node == null)
			return node;

		// Select subtree and go down until value is found
		if (value < node.value) {
			node.left = remove(node.left, value);
		} else if (value > node.value) {
			node.right = remove(node.right, value);
		} else {
			// Value found, remove node with one or no child
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}

			// Node with two children, get minimum value of right subtree, delete that value
			node.value = minValue(node.right);
			node.right = remove(node.right, node.value);
		}

		return node;
	}

	private int minValue(Node node) {
		int minValue = node.value;
		while (node.left != null) {
			minValue = node.left.value;
			node = node.left;
		}
		return minValue;
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