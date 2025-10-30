import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Manages the Trivia game state, including questions, scores, and gameplay logic.
 * This class provides functionality to load questions, manage the score, and control the flow of the game.
 */
public class Trivia {

    private int score = 0; // Tracks the player's current score
    private ArrayList<Question> triviaQuestions; // A list of all trivia questions in the game
    private int index = 0; // The index of the current question

    /**
     * Constructor initializes the Trivia object and loads the questions from an external file.
     */
    public Trivia() {
        triviaQuestions = new ArrayList<>();
        getallText(); // Load questions from the file
    }

    /**
     * Reads trivia questions from a file and populates the triviaQuestions list.
     * The file should contain questions and their answers in a specific format:
     * - Line 1: Question text
     * - Line 2: Correct answer
     * - Line 3: First incorrect answer
     * - Line 4: Second incorrect answer
     * - Line 5: Third incorrect answer
     * This sequence repeats for every question in the file.
     */
    private void getallText() {
        String q = null;   // Placeholder for the question text
        String a1 = null;  // Placeholder for the correct answer
        String a2 = null;  // Placeholder for the first incorrect answer
        String a3 = null;  // Placeholder for the second incorrect answer
        String a4 = null;  // Placeholder for the third incorrect answer
        int numOfLine = 0; // Tracks the current line number within the question set

        try {
            Scanner input = new Scanner(new File("trivia.txt")); // Opens the trivia file for reading
            while (input.hasNext()) {
                String text = input.nextLine(); // Read the next line of the file
                if (numOfLine == 0) q = text; // Line 1: Question text
                if (numOfLine == 1) a1 = text; // Line 2: Correct answer
                if (numOfLine == 2) a2 = text; // Line 3: First incorrect answer
                if (numOfLine == 3) a3 = text; // Line 4: Second incorrect answer
                if (numOfLine == 4) {
                    a4 = text; // Line 5: Third incorrect answer
                    triviaQuestions.add(new Question(q, a1, a2, a3, a4)); // Create a Question object and add to the list
                }
                numOfLine = (numOfLine + 1) % 5; // Reset after 5 lines (one full question set)
            }
            input.close(); // Close the file after reading
        } catch (IOException e) {
            System.out.println("File not found."); // Handle cases where the file is missing
        }
    }

    /**
     * Gets the player's current score.
     * @return The current score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Updates the player's score by adding or subtracting points.
     * @param points The number of points to add (positive) or subtract (negative).
     */
    public void setScore(int points) {
        score = points;
    }

    /**
     * Retrieves the next question in the list based on the current index.
     * @return The next Question object.
     */
    public Question getNewQuestion() {
        return triviaQuestions.get(index);
    }

    /**
     * Advances to the next question by incrementing the index.
     */
    public void setIndex() {
        index++;
    }

    /**
     * Retrieves the current index, representing the position of the current question.
     * @return The current index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the total number of questions available in the trivia game.
     * @return The number of questions.
     */
    public int getTriviaLength() {
        return triviaQuestions.size();
    }

    /**
     * Resets the question index to the start of the game.
     */
    public void setIndexToStartGame() {
        index = 0;
    }

    /**
     * Randomly shuffles the list of trivia questions to provide a new order for the game.
     */
    public void shuffleQuestions() {
        Collections.shuffle(triviaQuestions);
    }
}
