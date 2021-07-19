package data_structures.segment_tree;

import java.util.Arrays;

public class SegmentTree {

	private int st[];
	private int len;

	public SegmentTree(int[] arr) {
		len = arr.length;

		// Calculate max possible size for the tree
		int x = (int) (Math.ceil(Math.log(len) / Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, x) - 1;

		st = new int[max_size];

		// Construct initial segment tree
		construct(arr, 0, 0, len - 1);
	}

	private void construct(int[] arr, int vertex, int left, int right) {
		if (left == right) {
			// Leaf node, set value from array
			st[vertex] = arr[left];
		} else {
			int mid = (left + right) / 2;

			// Non-leaf node, construct subtree for left and right child
			construct(arr, vertex * 2 + 1, left, mid);
			construct(arr, vertex * 2 + 2, mid + 1, right);

			// Set node value as sum of left and right child from segment tree
			st[vertex] = st[vertex * 2 + 1] + st[vertex * 2 + 2];
		}
	}

	public int sum(int start, int end) {
		return sum(0, 0, len - 1, start, end);
	}

	private int sum(int vertex, int vleft, int vright, int left, int right) {
		if (left > right)
			// Invalid range
			return 0;
		if (vleft == left && vright == right) {
			// Range overlaps the nodes range
			return st[vertex];
		}

		int mid = (vleft + vright) / 2;
		return sum(vertex * 2 + 1, vleft, mid, left, Math.min(right, mid))
				+ sum(vertex * 2 + 2, mid + 1, vright, Math.max(left, mid + 1), right);
	}

	public void update(int position, int value) {
		update(0, 0, len - 1, position, value);
	}

	private void update(int vertex, int vleft, int vright, int position, int new_value) {
		if (vleft == vright) {
			// Leaf node, update value
			st[vertex] = new_value;
		} else {
			int mid = (vleft + vright) / 2;

			// Update for left or right subtree
			if (position <= mid)
				update(vertex * 2 + 1, vleft, mid, position, new_value);
			else
				update(vertex * 2 + 2, mid + 1, vright, position, new_value);

			// Update node value after leaf node update
			st[vertex] = st[vertex * 2 + 1] + st[vertex * 2 + 2];
		}
	}

	public void print() {
		System.out.println("Segment Tree: " + Arrays.toString(st) + "\n");
	}

}