package cmp326;

public class Quiz7 {

	public static int  countIf(String s){
		//base case
		if (s.length() < 2) {
			return 0;
		}
		// recursive case
		if (s.substring(0, 2).equals ("if")) {
			return 1 + countIf(s.substring(2));
			
		}
	}
	
}
