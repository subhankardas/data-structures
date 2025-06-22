package practice.t2_arrays.p1_two_pointers;

public class IndexFirstOccurrenceInString {

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("mississippi", "pi"));
    }

    // Simple two-pointer approach to find the first occurrence of a substring
    // (needle) in a string (haystack)
    // Time Complexity: O(n * m) where n is the length of haystack and m is the
    // length of needle
    // Space Complexity: O(1) since we are using constant extra space
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // If needle is empty, return 0
        } else if (haystack.isEmpty() || haystack.length() < needle.length()) {
            return -1; // If haystack is empty or shorter than needle, return -1
        }

        int ndlPtr = 0; // Pointer for needle
        int hsPtr = 0; // Pointer for haystack

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            ndlPtr = 0; // Reset needle pointer for each new position in haystack
            hsPtr = i; // Start checking from the current position in haystack

            // Match characters of haystack and needle while they are equal
            while (hsPtr < haystack.length() && ndlPtr < needle.length()
                    && haystack.charAt(hsPtr) == needle.charAt(ndlPtr)) {
                hsPtr++;
                ndlPtr++;
            }

            if (ndlPtr == needle.length()) {
                return i; // If needle is found, return the index
            }
        }

        return -1; // If needle is not found, return -1
    }

}
