package week5.guessingapplication;

import java.util.ArrayList;
import java.util.Scanner;

public class GuessAppUsingArrayList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> guessedNumbers = new ArrayList<Integer>();
		
		int randomNumber = (int) (Math.random() * 10);
		while(true) {
			System.out.println("Guess (1-10)?");
			String guessInput = scanner.nextLine();
			int guess = Integer.parseInt(guessInput);
			
			if(guess == randomNumber) {
				System.out.println("Lurus");
				break;
			} else {
				for(int i = 0; i < guessedNumbers.size(); i++) {
					if(guess == guessedNumbers.get(i)) {
						System.out.println("Sudah teka " + guess);
						break;
					}
				}
				guessedNumbers.add(guess);
				System.out.println("Salah");
			}
		}
		
		scanner.close();
	}
	
}
