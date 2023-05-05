/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: 2/27/2023
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nathan Loney
 */

import java.util.Scanner;

public class RandomNumberGenerator {
	public static void main(String[] args) {
		boolean again = true;

		Scanner hi = new Scanner(System.in);

		while(again) {
			int number = RNG.rand();
			int guess = 0;
			int lowGuess = 1;
			int highGuess = 100;
			String again2;


			System.out.println("This application generates a random integer between 1 and 100");
			System.out.println("and asks the user to guess repeatedly until they guess correctly.");
			System.out.println(" ");
			System.out.println("Enter your first guess:");

			guess = hi.nextInt();
			
			if (guess>100 || guess <1) {
				System.out.println("Invalid number. Try again");
			}
			while(RNG.getCount()<=RNG.getMaxGuessCount() && guess!=number && (guess>100 || guess <1)) {
				RNG.incrementCount();
				if (RNG.getCount()<=RNG.getMaxGuessCount()) {
					if (guess > number){
						if (guess < highGuess) {
							highGuess = guess;
						}

						System.out.println("Your guess is too high");
						System.out.println("Number of guesses is " + RNG.getCount());
						System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);

						guess = hi.nextInt();

					} else if (guess < number) {
						if (guess > lowGuess) {
							lowGuess = guess;
						}

						System.out.println("Your guess is too low");
						System.out.println("Number of guesses is " + RNG.getCount());
						System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);

						guess = hi.nextInt();

					}
				} else if (RNG.getCount()>RNG.getMaxGuessCount() && guess!=number) {
					System.out.println("You have exceeded the maximum number of guesses, 7. Try again");

					again = false;
				}
			}
			if (guess == number) {
				System.out.println("Congratulations, you guessed correctly.");
				System.out.println("Try again? (y or n)");

				again2 = hi.nextLine();
				again2 = hi.next();

				if (again2.equals("y")) {
					RNG.resetCount();
					again = true;
				} else if(again2.equals("n")) {
					again = false;
				}
			}
		}
	}
}
