package dynamic_array;

public class DynamicArrayMain {

	public static void main(String[] args) {

		DynamicArray<Integer> dynarr = new DynamicArray<>();

		dynarr.add(1);
		dynarr.add(2);
		dynarr.add(2);
		dynarr.add(4);

		System.out.println(dynarr);

		dynarr.add(5);

		System.out.println(dynarr);

		dynarr.set(3, 2);

		System.out.println(dynarr);

		dynarr.removeAt(4);

		System.out.println(dynarr);

		dynarr.remove(4);

		System.out.println(dynarr);

		dynarr.add(4);
		dynarr.add(5);

		System.out.println(dynarr);

	}

}
