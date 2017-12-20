package cmp326;

import java.util.Scanner;

public class Song {
	private String name;
	private int rating;
	
	//constructor
	public Song(String n, int r) {
		name = n;
		rating = r;
		
	}
	//toSring
	public String toString() {
		return name  + "("+ rating
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter song name:");
		String name = input.nextLine();
		System.out.println("Enter rating (1-5):");
		int rating = input.nextInt();
	}

}
