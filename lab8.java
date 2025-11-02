// *******************************************************
// lab8.java
// Author: Karissa Merillat
// Description: An AI bot that plays "Guess My Number" using
// a binary search approach. The bot predicts the max number
// of guesses (log2(n)), counts guesses, and detects incorrect
// user responses.
// *******************************************************

import java.util.Scanner;

public class lab8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Guess My Number AI!");
        System.out.print("Enter the largest possible number (upper limit): ");
        int max = input.nextInt();

        // calculate the maximum number of guesses (log2(max))
        int maxGuesses = (int) Math.ceil(Math.log(max) / Math.log(2));
        System.out.println("I can guess your number in at most " + maxGuesses + " guesses!");

        int low = 1;
        int high = max;
        int guessCount = 0;
        boolean found = false;

        while (!found && low <= high) {
            int guess = (low + high) / 2;
            guessCount++;

            System.out.println("\nGuess #" + guessCount + ": Is your number " + guess + "?");
            System.out.print("Type 'yes', 'higher', or 'lower': ");
            String response = input.next().toLowerCase();

            if (response.equals("yes")) {
                System.out.println("Yay! I guessed your number in " + guessCount + " guesses!");
                found = true;
            } 
            else if (response.equals("higher")) {
                low = guess + 1;
            } 
            else if (response.equals("lower")) {
                high = guess - 1;
            } 
            else {
                System.out.println("Invalid input! Please type 'yes', 'higher', or 'lower'.");
            }

            // Check for inconsistent answers
            if (low > high && !found) {
                System.out.println("\nHmm... something doesn’t add up.");
                System.out.println("It seems your responses were inconsistent!");
                System.out.println("Game over — please try again honestly next time!");
                break;
            }
        }

        input.close();
    }
}
