package data_structures.union_find;

public class UnionFindMain {

	public static final int SIZE = 7;
	public static UnionFind uf;

	public static void main(String[] args) {

		uf = new UnionFind(SIZE);

		uf.unify(0, 1);
		uf.unify(1, 4);
		uf.unify(4, 2);

		print();

		uf.unify(3, 6);
		uf.unify(6, 5);

		print();

		uf.unify(1, 6);

		print();

	}

	public static void print() {
		for (int elem = 0; elem < SIZE; elem++) {
			System.out.println("Group ID of " + elem + ": " + uf.find(elem));
		}
		System.out.println("Total No. Of Groups: " + uf.groups() + "\n");
	}

}
