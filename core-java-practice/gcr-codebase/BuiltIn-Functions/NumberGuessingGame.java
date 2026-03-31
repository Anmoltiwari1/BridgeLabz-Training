import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        boolean correct = false;

        while (!correct && low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            String feedback = sc.nextLine();

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("I guessed it!");
                correct = true;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            }
        }

        if (!correct) {
            System.out.println("Something went wrong. Are you sure about your answers?");
        }

        sc.close();
    }

    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }
}