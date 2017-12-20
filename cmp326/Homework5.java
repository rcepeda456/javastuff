package cmp326;
import java.util.Scanner;

/*  This program as the user for two integer, and recursively computes
 * the sum of all the numbers between them, inclusive.
 */

public class Homework5 {

	public static void main(String[] args) {
		// initialize a Scanner object to get keyboard input
		Scanner keyboard = new Scanner(System.in);
				
		// ask the user for a number
		System.out.println("Enter an integer:");
		int num1 = keyboard.nextInt();
		
		// ask the user for a larger number
		System.out.println("Enter another larger integer:");
		int num2 = keyboard.nextInt();
				
		// tell the user the sum of the numbers between the two integers
		System.out.println("The sum of all integers between " + num1 + " and " + num2 
				+ ", inclusive, is " + sumBetween(num1,num2));	
				
		// close the Scanner object
		keyboard.close();
	}

	//  This method recursively sums the numbers between m and n, inclusive.
	// Assume n >= m.
	public static int sumBetween(int m, int n) {
		// base case
		if(n <= m) return 0;
		
		return m + sumBetween(m+1,n-1) + n;

		
		// recursive case
		
	}
}