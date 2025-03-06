import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7; // Limit number of attempts
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    hasGuessedCorrectly = true;
                    break;
                } else if (Math.abs(userGuess - numberToGuess) <= 5) {
                    System.out.println("🔥 Very close! Try again.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("📉 Too low! Try again.");
                } else {
                    System.out.println("📈 Too high! Try again.");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (!hasGuessedCorrectly) {
                System.out.println("❌ Sorry, you're out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("🏆 Thank you for playing! Your final score: " + totalScore);
        scanner.close();
    }
}