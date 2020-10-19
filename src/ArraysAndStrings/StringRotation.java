package ArraysAndStrings;

public class StringRotation {
/*
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2m write code to check if s2 is a rotation of s1 using only on call to 
 * isSubstring. (e.g. "waterbottle" is a rotation of "erbottlewat")
 */
	public static boolean isSubstring(String s1, String s2) {
		return s2.indexOf(s1) != -1;
	}
	public static boolean isRotation(String s1, String s2) {
		return s1.length() == s2.length() && isSubstring(s1, s2+s2);
	}
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		
		System.out.println(isRotation(s1, s1));
	}
}
