package ArraysAndStrings;

public class OneAway {
	/*
	 * There are three types of edits that can be performed on strings: insert a character,
	 * remove a character, or replace a character. Given two strings, write a function to check if hey are one 
	 * edit (or zero edits) away.
	 */
	public static boolean OneEditAway(String s1, String s2){
		if(Math.abs(s1.length() - s2.length()) >= 2)
			return false;
		
		int edits = 0;
		int index1 = 0;
		int index2 = 0;
		
		String first = s1.length() < s2.length() ? s1 : s2;
		String second = s1.length() < s2.length() ? s2 :s1;
		
		
		if(second.length() > first.length()) {
			while(index1 < first.length()) {
				if(second.charAt(index2) == first.charAt(index1)) {
					index2++;
					index1++;
				}else {
					edits++;
					if(second.charAt(index2 + 1) != first.charAt(index1)) {
						return false;
					}else {
						index2+=2;
						index1++;
					}
				}
			}
		}
		
		else {
			while(index1 < first.length()) {
				if(first.charAt(index1) != second.charAt(index2)) {
					edits++;
				}
				index1++;
				index2++;
			}
		}
			
		return edits <= 1;
	}
	
	
	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "ple";
		System.out.println(OneEditAway(s1, s2));
	}
}
