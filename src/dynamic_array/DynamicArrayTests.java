package dynamic_array;

public class DynamicArrayTests<T> {

	public static void main(String args[]) {

		DynamicArray<Integer> arr = new DynamicArray<>();

		arr.add(3);

		assertEquals(1, arr.length());

		arr.add(2);
		arr.add(1);

		assertEquals(3, arr.length());

		arr.set(0, 1);
		arr.set(2, 3);

		assertEquals(arr.get(0), 1);
		assertEquals(arr.get(2), 3);

		arr.removeAt(0);

		assertEquals(2, arr.length());
		assertEquals(3, arr.get(1));
		assertEquals(0, arr.indexOf(2));

		assertEquals(false, arr.contains(1));

		arr.clear();

		assertEquals(true, arr.isEmpty());

	}

	public static void assertEquals(Integer expected, Integer actual) {
		System.out.println(expected.equals(actual) ? "[*] SUCCESS" : "[X] FAILURE");
	}

	private static void assertEquals(Boolean expected, Boolean actual) {
		System.out.println(expected.equals(actual) ? "[*] SUCCESS" : "[X] FAILURE");
	}

}
