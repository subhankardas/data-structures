package data_structures.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

	// Binary Tree Node [Value, Left Child Node, Right Child Node]
	class Node {
		T value;
		Node left;
		Node right;

		public Node(T value) {
			this.value = value;
		}
	}

	// Points to the root node
	private Node root;

	// List of nodes while traversal
	private Queue<Node> nodes = new LinkedList<>();

	public BinaryTree() {
		root = null;
	}

	// Setters for adding child nodes explicitly to parent nodes
	public BinaryTree<T>.Node setRootNode(T value) {
		root = new Node(value);
		return root;
	}

	public BinaryTree<T>.Node setLeftNode(Node node, T value) {
		node.left = new Node(value);
		return node.left;
	}

	public BinaryTree<T>.Node setRightNode(Node node, T value) {
		node.right = new Node(value);
		return node.right;
	}

	// Getters for getting node values
	public T getRootNode() {
		return root != null ? root.value : null;
	}

	public T getLeftNode(Node node) {
		return node.left != null ? node.left.value : null;
	}

	public T getRightNode(Node node) {
		return node.right != null ? node.right.value : null;
	}

	// Preorder DFS Traversal Implementation [Root -> Left -> Right]
	public void preorderDFS(Node node) {
		// Read current node value
		System.out.println(node.value);

		if (node.left != null) {
			// Traverse to current node's left child
			preorderDFS(node.left);
		}

		if (node.right != null) {
			// Traverse to current node's right child
			preorderDFS(node.right);
		}
	}

	// Inorder DFS Traversal Implementation [Left -> Root -> Right]
	public void inorderDFS(Node node) {
		if (node.left != null) {
			// Traverse to current node's left child
			inorderDFS(node.left);
		}

		// Read current node value
		System.out.println(node.value);

		if (node.right != null) {
			// Traverse to current node's right child
			inorderDFS(node.right);
		}
	}

	// Postorder DFS Traversal Implementation [Left -> Right -> Root]
	public void postorderDFS(Node node) {
		if (node.left != null) {
			// Traverse to current node's left child
			postorderDFS(node.left);
		}

		if (node.right != null) {
			// Traverse to current node's right child
			postorderDFS(node.right);
		}

		// Read current node value
		System.out.println(node.value);
	}

	// BFS Traversal Implementation
	public void BFS(Node node) {
		// Read current node value
		System.out.println(node.value);

		if (node.left != null) {
			// Add current node's left child to queue
			nodes.add(node.left);
		}

		if (node.right != null) {
			// Add current node's right child to queue
			nodes.add(node.right);
		}

		// If queue has nodes to read, pop and read the next node in queue
		if (!nodes.isEmpty()) {
			BFS(nodes.remove());
		}
	}

	// Insert element after last node
	public void insert(Node node, T value) {
		// Node is the first i.e root node
		if (node == null) {
			root = new Node(value);
			return;
		}

		// Add the traversal node to queue that stores nodes to visit
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(node);

		// Loop till queue is empty i.e no nodes left to visit
		while (!nodes.isEmpty()) {
			// Visit the next node in queue
			Node temp = nodes.peek();
			nodes.remove();

			// If node left child is null, add new node to it else add left node to queue
			if (temp.left == null) {
				temp.left = new Node(value);
				break;
			} else
				nodes.add(temp.left);

			// If node right child is null, add new node to it else add right node to queue
			if (temp.right == null) {
				temp.right = new Node(value);
				break;
			} else
				nodes.add(temp.right);
		}
	}

	public void remove(Node node, T value) {
		// Return if node does not exist
		if (node == null) {
			return;
		}

		// If left node of current node has value remove it else go down to left
		if (node.left != null && node.left.value == value) {
			node.left = null;
		} else
			remove(node.left, value);

		// If right node of current node has value remove it else go down right
		if (node.right != null && node.right.value == value) {
			node.right = null;
		} else
			remove(node.right, value);
	}

}
