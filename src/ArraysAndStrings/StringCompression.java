package ArraysAndStrings;

public class StringCompression {
/*
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa. if the compressed string would not become smaller than the original string, your method
 * should return the original string. You can assume the string has only uppercase an lowercase letters. (a-z)
 */
	public static String compressString(String s) {
		StringBuilder compressed = new StringBuilder();
		int consecutive = 0;
		
		for(int i=0; i<s.length(); i++) {
			consecutive++;
			if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressed.append(s.charAt(i));
				compressed.append(consecutive);
				consecutive = 0;
			}
		}
		return compressed.length() < s.length() ? compressed.toString() : s;
	}
	
	public static void main(String[] args) {
		String str =  "aabcccccaaa";
		System.out.println(compressString(str));
	}
}
