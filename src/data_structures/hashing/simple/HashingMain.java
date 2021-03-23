package data_structures.hashing.simple;

public class HashingMain {

	public static void main(String[] args) {
		indexMapFunctions();
	}

	public static void indexMapFunctions() {
		// Index map functions
		IndexMap map = new IndexMap();

		// Insertion
		map.insert(100);
		map.insert(-99);
		map.insert(4);
		map.insert(0);

		// Search
		System.out.println(map.search(100));
		System.out.println(map.search(-99));
		System.out.println(map.search(1));
		System.out.println(map.search(4));
		System.out.println(map.search(-4));
		System.out.println(map.search(0));

		// Removal
		map.remove(4);
		map.remove(0);
		map.remove(-45);

		// Search
		System.out.println(map.search(4));
		System.out.println(map.search(0));
		System.out.println(map.search(-45));
	}

}
