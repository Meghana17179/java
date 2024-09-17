import java.io.*;
import java.util.Scanner;

public class NumberGuessingGame 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int min_range = 1;
        int max_range = 100;
        int max_attempts = 5;
        int rounds = 0;
        int total_attempts = 0;
        int totalRoundsWon = 0;

        while (true) 
        {
            rounds++;
            int secretNumber = (int) (Math.random() * (max_range - min_range + 1)) + min_range;
            int attempts = 0;

            System.out.println("Round " + rounds);
            System.out.println("Guess a number between " + min_range + " and " + max_range + ". You have " + max_attempts + " attempts.");

            while (attempts < max_attempts) 
            {
                attempts++;
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == secretNumber) 
                {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalRoundsWon++;
                    total_attempts += attempts;
                    break;
                } 
                else if (guess < secretNumber)
                {
                    System.out.println("Your guess is too low.");
                } 
                else
               {
                    System.out.println("Your guess is too high.");
                }
            }

            if (attempts == max_attempts) 
            {
                System.out.println("Sorry, you ran out of attempts. The secret number was " + secretNumber + ".");
                total_attempts += max_attempts;
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes"))
            {
                break;
            }
        }

        System.out.println("Game over!");
        System.out.println("You played " + rounds + " rounds and won " + totalRoundsWon + ".");
        System.out.println("Your average attempts per round: " + (double) total_attempts / rounds);
    }
}
