package data_structures.binary_tree.simple;

import data_structures.binary_tree.simple.BinaryTree.Node;

@SuppressWarnings("unchecked")
public class BinaryTreeMain {

	public static void main(String[] args) {
		arrayBinaryTreeImpl();
		binaryTreeImpl();
		binaryTreeInsertionImpl();
	}

	private static void arrayBinaryTreeImpl() {
		System.out.println("Binary Tree using Array -");
		ArrayBinaryTree<Character> btree = new ArrayBinaryTree<>(10);

		btree.setRootNode('A');

		btree.setLeftNode(1, 'B');
		btree.setRightNode(1, 'C');

		btree.setLeftNode(2, 'D');
		btree.setRightNode(2, 'E');

		System.out.println("Binary Tree > " + btree);

		System.out.println(btree.getRootNode());

		System.out.println(btree.getLeftNode(1));
		System.out.println(btree.getRightNode(1));

		System.out.println(btree.getLeftNode(2));
		System.out.println(btree.getRightNode(2));
		System.out.println();
	}

	@SuppressWarnings("rawtypes")
	private static void binaryTreeImpl() {
		System.out.println("Binary Tree -");
		BinaryTree<Character> btree = new BinaryTree<>();

		Node root = btree.setRootNode('A');

		Node n2 = btree.setLeftNode(root, 'B');
		Node n3 = btree.setRightNode(root, 'C');

		btree.setLeftNode(n2, 'D');
		btree.setRightNode(n2, 'E');

		btree.setLeftNode(n3, 'F');

		System.out.println(root.value);

		System.out.println(btree.getLeftNode(root));
		System.out.println(btree.getRightNode(root));

		System.out.println(btree.getLeftNode(n2));
		System.out.println(btree.getRightNode(n2));

		System.out.println(btree.getLeftNode(n3));
		System.out.println(btree.getRightNode(n3));

		System.out.println();
		System.out.println("Preorder DFS Traversal -");
		btree.preorderDFS(root);

		System.out.println();
		System.out.println("Inorder DFS Traversal -");
		btree.inorderDFS(root);

		System.out.println();
		System.out.println("Postorder DFS Traversal -");
		btree.postorderDFS(root);

		System.out.println();
		System.out.println("BFS Traversal -");
		btree.BFS(root);
	}

	@SuppressWarnings("rawtypes")
	private static void binaryTreeInsertionImpl() {
		BinaryTree<Character> btree = new BinaryTree<>();

		Node root = btree.setRootNode('A');

		btree.insert(root, 'B');
		btree.insert(root, 'C');
		btree.insert(root, 'D');
		btree.insert(root, 'E');

		System.out.println();
		System.out.println("Insertion -");
		btree.BFS(root);

		btree.remove(root, 'D');
		btree.remove(root, 'C');

		System.out.println();
		System.out.println("Deletion -");
		btree.BFS(root);
	}
}
