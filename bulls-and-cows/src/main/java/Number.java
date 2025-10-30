import java.util.Random;

/**
 * The Number class represents the logic of the "Bulls and Cows" game.
 * It handles the generation of a random number, validation of user inputs,
 * and the calculation of bulls and cows based on the user's guess.
 */
public class Number {
    private String number; // The random 4-digit number to guess
    private int numOfGuess = 0; // Number of guesses made by the user
    private String guess = ""; // String containing all previous guesses and their results
    private String message = ""; // Message for the user (e.g., error messages)
    private static final int DIGITS_COUNT = 4; // The length of the number to guess

    /**
     * Constructor for the Number class.
     * Initializes the game by generating a random number.
     */
    public Number() {
        restart();
    }

    /**
     * Resets the game by generating a new random 4-digit number and clearing previous data.
     */
    public void restart() {
        Random random = new Random();
        int randomNum = 1000 + random.nextInt(8999); // Generate a random 4-digit number
        while (!isUniqueNum(String.valueOf(randomNum)))
            randomNum = 1000 + random.nextInt(8999);
        number = String.valueOf(randomNum);
        numOfGuess = 0;
        guess = "";
        message = "";
    }

    /**
     * Checks if the user's guess matches the random number and calculates bulls and cows.
     * @param userString The user's guess as a string.
     * @return True if the guess is correct, otherwise False.
     */
    public boolean isTheNum(String userString) {

        if (userString.length() != DIGITS_COUNT) {
            message = "The number must be 4 digits long";
            return false;
        }

        if (!isJostNum(userString)) {
            message = "All characters must be numeric";
            return false;
        }

        if (!isUniqueNum(userString)) {
            message = "The digits in the number must be unique";
            return false;
        }

        if (userString.equals(number)) {
            guess += "guess: " + userString + ",    bull: 4,    cow: 0.";
            numOfGuess++;
            return true;
        }

        int bull = 0;
        int cow = 0;

        // Count bulls (correct digits in the correct position)
        for (int i = 0; i < DIGITS_COUNT; i++) {
            if (number.charAt(i) == userString.charAt(i))
                bull++;
        }

        // Count cows (correct digits in the wrong position)
        for (int i = 0; i < DIGITS_COUNT; i++) {
            if (number.contains(String.valueOf(userString.charAt(i)))) {
                cow++;
            }
        }

        message = "";
        cow -= bull;
        numOfGuess++;
        guess += "guess: " + userString + ",    bull: " + bull + ",    cow: " + cow + ".\n";

        return false;
    }

    /**
     * Checks if the given number has unique digits.
     * @param num The number as a string.
     * @return True if all digits are unique, otherwise False.
     */
    private boolean isUniqueNum(String num) {
        boolean[] fourDigits = new boolean[10]; // Array to track digits
        String numAsString = String.valueOf(num);

        for (int i = 0; i < DIGITS_COUNT; i++) {
            int digit = numAsString.charAt(i) - '0';
            if (fourDigits[digit])
                return false;
            fourDigits[digit] = true;
        }
        return true;
    }

    /**
     * Checks if all characters in the string are numeric digits.
     * @param str The input string.
     * @return True if all characters are digits, otherwise False.
     */
    private boolean isJostNum(String str) {
        for (int i = 0; i < DIGITS_COUNT; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    /**
     * Gets the latest message for the user.
     * @return The message string.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets all previous guesses and their results.
     * @return The guess string.
     */
    public String getGuess() {
        return guess;
    }

    /**
     * Gets the total number of guesses made by the user.
     * @return The number of guesses.
     */
    public int getNumOfGuess() {
        return numOfGuess;
    }
}
