package ArraysAndStrings;

public class CheckPermutation {
	/*
	 * Given two strings, write a method to decide if one is a permutation of the other
	 */
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	public static boolean checkPerm(String str1, String str2) {
		return sort(str1).equals(sort(str2));
	}
	
	public static void main(String[] args) {
		String s1 = "apple";
		String s2 = "papel";
		
		System.out.println(checkPerm(s1, s2));
	}
}
