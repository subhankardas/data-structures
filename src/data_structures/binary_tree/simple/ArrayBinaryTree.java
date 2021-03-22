package data_structures.binary_tree.simple;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class ArrayBinaryTree<T> {

	private int size;
	private T[] tree;
	private int len = 0;

	public ArrayBinaryTree() {
		this(10);
	}

	public ArrayBinaryTree(int size) {
		this.size = size;
		tree = (T[]) new Object[size];
	}

	public void setRootNode(T root) {
		tree[0] = root;
		len++;
	}

	public void setLeftNode(int pos, T left) {
		int currIdx = pos - 1;
		int leftChildIdx = (2 * currIdx) + 1;
		if (leftChildIdx >= size) {
			throw new RuntimeException("Tree size exhausted.");
		}
		tree[leftChildIdx] = left;
		len++;
	}

	public void setRightNode(int pos, T right) {
		int currIdx = pos - 1;
		int rightChildIdx = (2 * currIdx) + 2;
		if (rightChildIdx >= size) {
			throw new RuntimeException("Tree size exhausted.");
		}
		tree[rightChildIdx] = right;
		len++;
	}

	public T getRootNode() {
		return tree[0];
	}

	public T getLeftNode(int pos) {
		int currIdx = pos - 1;
		int leftChildIdx = (2 * currIdx) + 1;
		if (leftChildIdx >= size) {
			throw new RuntimeException("Tree size exhausted.");
		}
		return tree[leftChildIdx];
	}

	public T getRightNode(int pos) {
		int currIdx = pos - 1;
		int rightChildIdx = (2 * currIdx) + 2;
		if (rightChildIdx >= size) {
			throw new RuntimeException("Tree size exhausted.");
		}
		return tree[rightChildIdx];
	}

	@Override
	public String toString() {
		T[] out = Arrays.copyOfRange(tree, 0, len);
		return Arrays.toString(out);
	}

}
