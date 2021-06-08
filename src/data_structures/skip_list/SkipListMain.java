package data_structures.skip_list;

public class SkipListMain {

	public static SkipList<Integer> skiplist;

	public static void main(String[] args) {

		skiplist = new SkipList<>();

		skiplist.add(1);
		skiplist.add(2);
		skiplist.add(3);
		skiplist.add(4);
		skiplist.add(5);
		skiplist.add(6);
		skiplist.add(7);
		skiplist.add(8);
		skiplist.add(9);
		skiplist.add(10);

		System.out.println("Normal lane:" + skiplist.print(false));
		System.out.println("Express lane:" + skiplist.print(true) + "\n");

		System.out.println("Found 2: " + skiplist.search(2) + "  Scans: " + skiplist.scans);
		System.out.println("Found 4: " + skiplist.search(4) + "  Scans: " + skiplist.scans);
		System.out.println("Found 6: " + skiplist.search(6) + "  Scans: " + skiplist.scans);
		System.out.println("Found 12: " + skiplist.search(12) + "  Scans: " + skiplist.scans);

	}

}
