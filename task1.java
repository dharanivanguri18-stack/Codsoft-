import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        char playAgain = 'y';
        int userScore = 0;     // Score for rounds won

        while (playAgain == 'y' || playAgain == 'Y') {

            int secretNumber = rand.nextInt(100) + 1;
            int attempts = 0, maxAttempts = 10;
            boolean guessedCorrect = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.\n");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! This counts as one attempt.\n");
                    sc.nextLine();  // Clear invalid
                    attempts++;     // Count this as a guess
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Correct! You guessed the number!");
                    System.out.println("It is " + secretNumber);
                    guessedCorrect = true;

                    userScore++;   // Increase score for winning the round
                    break;
                } 
                else if (guess > secretNumber) {
                    System.out.println("Too high! Try lower.");
                } 
                else {
                    System.out.println("Too low! Try higher.");
                }
            }

            if (!guessedCorrect) {
                System.out.println("\nYou did not guess the number.");
                System.out.println("The correct number was: " + secretNumber);
            }


            System.out.println("\nRounds won so far: " + userScore);

            System.out.print("\nPlay again? (y/n): ");
            if (!sc.hasNext()) {
                System.out.println("\nNo input. Exiting game.");
                break;
            }

            playAgain = sc.next().charAt(0);
            sc.nextLine();
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Your FINAL score (total rounds won): " + userScore);
    }
}

