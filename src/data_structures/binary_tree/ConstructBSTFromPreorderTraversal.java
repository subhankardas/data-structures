package data_structures.binary_tree;

/**
 * Construct BST from given preorder traversal 
 * [10, 5, 1, 7, 40, 50]
 * Preorder = ROOT -> LEFT CHILD -> RIGHT CHILD
 * 
 * 10 -> 5, 1, 7 -> 40, 50
 * 
 * 10 -> 5 -> 1, 7 -> 40 -> 50
 * 
 */
public class ConstructBSTFromPreorderTraversal {

	public static void main(String[] args) {
		int elems[] = { 10, 5, 1, 7, 40, 50 };

		// Construct BST from preorder traversal array
		Node root = construct(elems, 0, elems.length - 1);

		preorderDFS(root);
	}

	public static Node construct(int elems[], int start, int end) {
		// Base case
		if (start > end) {
			return null;
		}

		// First element of the array is root
		Node parent = new Node(elems[start]);

		// Find index of element that has value greater than root in the remaining array
		int idx;
		for (idx = start; idx <= end; idx++) {
			if (elems[idx] > parent.value)
				break;
		}

		// Get left child node from left side of array
		parent.left = construct(elems, start + 1, idx - 1);

		// Get right child node from right side of array
		parent.right = construct(elems, idx, end);

		return parent;
	}

	public static void preorderDFS(Node node) {
		// Read current node value
		System.out.print(node.value + "   ");

		if (node.left != null) {
			// Traverse to current node's left child
			preorderDFS(node.left);
		}

		if (node.right != null) {
			// Traverse to current node's right child
			preorderDFS(node.right);
		}
	}
}

class Node {
	int value;
	Node left, right;

	Node(int key) {
		this.value = key;
	}
}