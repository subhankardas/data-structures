package data_structures.segment_tree;

import java.util.Arrays;

public class EfficientSegmentTree {

	private int[] est;
	private int len;

	public EfficientSegmentTree(int[] arr) {
		len = arr.length;
		est = new int[2 * len];

		construct(arr);
	}

	private void construct(int[] arr) {
		// Add leaf nodes
		for (int i = 0; i < len; i++)
			est[len + i] = arr[i];

		// Parent nodes for leaf nodes
		for (int i = len - 1; i > 0; i--)
			est[i] = est[2 * i] + est[2 * i + 1];
	}

	int sum(int l, int r) {
		int res = 0;
		r++;

		// Loop from both the range ends, find parent for leaf nodes
		for (l = l + len, r = r + len; l < r; l = l / 2, r = r / 2) {
			// Current left node is leaf node, add value to result and move forward
			if (l % 2 != 0) {
				res += est[l++];
			}
			// Current right node is leaf node, add previous nodes parent value
			if (r % 2 != 0) {
				res += est[--r];
			}
		}

		return res;
	}

	void update(int pos, int value) {
		// Set value at position i.e. leaf node
		est[pos + len] = value;
		pos = pos + len;

		// Move upward and update parents
		for (int i = pos; i > 1; i = i / 2)
			est[i / 2] = est[i] + est[i + 1];
	}

	public void print() {
		System.out.println("Segment Tree: " + Arrays.toString(est) + "\n");
	}

}
