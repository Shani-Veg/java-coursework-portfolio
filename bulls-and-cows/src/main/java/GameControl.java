import javax.swing.*;

/**
 * The GameControl class is the main driver of the "Bulls and Cows" game.
 * It manages user interaction using Swing dialogs and calls the Number class
 * to handle game logic.
 */
public class GameControl {
    public static void main(String[] args) {
        startGame();
    }

    /**
     * Starts the game loop, allowing the user to play multiple rounds.
     */
    public static void startGame() {
        Number number = new Number();
        boolean continuePlaying = true;

        while (continuePlaying) {
            number.restart();
            playRound(number);
            continuePlaying = askToPlayAgain();
        }

        showGoodbyeMessage();
    }

    /**
     * Plays a single round of the game, asking the user for a guess and validating it.
     * @param number The Number object that contains the game's logic.
     */
    private static void playRound(Number number) {
        boolean isValid = false;

        while (!isValid) {
            String input = JOptionPane.showInputDialog(null,
                    "Please enter a 4-digit number:",
                    "Input Number",
                    JOptionPane.QUESTION_MESSAGE);

            if (input != null) {
                input = input.trim();
                isValid = number.isTheNum(input);

                if (!isValid) {
                    if (number.getMessage().isEmpty()) {
                        showError(number.getGuess());
                    } else {
                        showError(number.getMessage());
                    }
                } else {
                    showSuccessMessage(number.getNumOfGuess());
                }
            } else {
                showError("No input provided. Please enter a valid 4-digit number.");
            }
        }
    }

    /**
     * Asks the user if they want to play another round.
     * @return True if the user chooses to play again, otherwise False.
     */
    private static boolean askToPlayAgain() {
        int response = JOptionPane.showConfirmDialog(null,
                "Do you want to play again?",
                "Play Again?",
                JOptionPane.YES_NO_OPTION);

        return response == JOptionPane.YES_OPTION;
    }

    /**
     * Displays an error message to the user.
     * @param message The error message.
     */
    private static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a success message when the user guesses the correct number.
     * @param numOfGuesses The total number of guesses the user made.
     */
    private static void showSuccessMessage(int numOfGuesses) {
        JOptionPane.showMessageDialog(null,
                "You guessed the correct number!\nNumber of guesses: " + numOfGuesses,
                "Correct Number!",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays a goodbye message when the game ends.
     */
    private static void showGoodbyeMessage() {
        JOptionPane.showMessageDialog(null,
                "Thanks for playing!\nSee you next time!",
                "Goodbye",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
