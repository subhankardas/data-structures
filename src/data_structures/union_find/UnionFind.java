package data_structures.union_find;

public class UnionFind {

	// Stores count of elements for each group ID
	private int size[];

	// Stores parent ID for this element
	private int id[];

	// Total no. of groups
	private int groups;

	public UnionFind(int sz) {
		if (sz == 0)
			throw new RuntimeException("Size cannot be zero.");

		size = new int[sz];
		id = new int[sz];
		groups = sz;

		// Initialize all elements to point to self and sizes to 1
		for (int idx = 0; idx < sz; idx++) {
			id[idx] = idx;
			size[idx] = 1;
		}
	}

	public int find(int n) {
		// Find the root node for the index
		int root = n;
		while (root != id[root])
			root = id[root];

		/*
		 * Perform path compression for amortized time complexity i.e instead of
		 * pointing to the adjacent parent make this element point to the root of all
		 * parent elements. So that all elements of the same groups always point to the
		 * root for the group. Hence finding element's root is efficient.
		 */
		while (n != root) {
			int next = id[n];
			id[n] = root;
			n = next;
		}

		return root;
	}

	public void unify(int p, int q) {
		// Return if already in same group
		if (connected(p, q))
			return;

		int rootp = find(p);
		int rootq = find(q);

		// If group P has more elements, merge group Q into P, else do the opposite
		if (size[rootp] > size[rootq]) {
			size[rootp] += size[rootq];
			id[q] = rootp;
		} else {
			size[rootq] += size[rootp];
			id[p] = rootq;
		}

		// Reduce the group count
		groups--;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int elementsInGroupOf(int p) {
		return size[find(p)];
	}

	public int groups() {
		return groups;
	}

}
