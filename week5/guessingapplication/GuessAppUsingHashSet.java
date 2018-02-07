package week5.guessingapplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GuessAppUsingHashSet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashSet<Integer> guessedNumbers = new HashSet<Integer>();
		
		int randomNumber = (int) (Math.random() * 10);
		while(true) {
			System.out.println("Guess (1-10)?");
			String guessInput = scanner.nextLine();
			int guess = Integer.parseInt(guessInput);
			
			if(guess == randomNumber) {
				System.out.println("Lurus");
				break;
			} else {
				if(!guessedNumbers.add(guess)) {
					System.out.println("Sudah teka " + guess);
				}
				System.out.println("Salah");
			}
		}
		
		scanner.close();
	}
	
}
