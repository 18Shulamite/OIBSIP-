import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Game configuration
        int maxAttempts = 10; // Maximum attempts allowed
        int rounds = 3; // Number of rounds
        int totalScore = 0; // Total score of the player

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + round + " starts now!");
            System.out.println("Guess a number between 1 and 100:");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    int points = maxAttempts - attempts + 1;
                    totalScore += points;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts. You earn "
                            + points + " points.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (attempts == maxAttempts && !hasGuessedCorrectly) {
                    System.out.println(
                            "Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
                }
            }
        }

        System.out.println("\nGame over! Your total score is " + totalScore + " points.");
        scanner.close();
    }
}
