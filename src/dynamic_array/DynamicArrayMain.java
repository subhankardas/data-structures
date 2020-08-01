package dynamic_array;

public class DynamicArrayMain {

	public static void main(String[] args) {

		DynamicArray<Integer> dynarr = new DynamicArray<>();

		dynarr.add(1);
		dynarr.add(3);
		dynarr.add(2);
		dynarr.add(4);

		System.out.println(dynarr);

		dynarr.add(5);

		System.out.println(dynarr);

		dynarr.set(1, 2);
		dynarr.set(2, 3);

		System.out.println(dynarr);

		dynarr.removeAt(2);
		dynarr.removeAt(2);

		System.out.println(dynarr);

		dynarr.remove(5);
		dynarr.add(3);

		System.out.println(dynarr);

		System.out.println(dynarr.length());
		System.out.println(dynarr.isEmpty());
		System.out.println(dynarr.get(2));
		System.out.println(dynarr.indexOf(2));
		System.out.println(dynarr.contains(3));

		dynarr.clear();

		System.out.println(dynarr.length());
		System.out.println(dynarr.isEmpty());

	}

}
