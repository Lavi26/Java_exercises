package org.espire.permutationString;

public class PermutationString {
	
	public static void permutationString(String str, Integer start, Integer last) {

		// print permutation
		if (start == last) {
			System.out.println(str);
		} else {
			for (int i = start; i <= last; i++) {

				// swapping string by fixing a character
				str = swap(str, start, i);

				// recursively calling
				permutationString(str, start + 1, last);

				// backtracking and swapping
				str = swap(str, start, i);
			}
		}
	}

	// function for swapping character at position
	public static String swap(String a, Integer i, Integer j) {

		char temp;
		char charArray[] = a.toCharArray();

		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);

	}

	public static void main(String args[]) {

		PermutationString.permutationString("xyz", 0, 2);
	}

}
