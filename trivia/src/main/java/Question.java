import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a single question in the Trivia game.
 * Each question includes the question text, a list of possible answers,
 * and the correct answer. The possible answers are shuffled to randomize their order.
 */
public class Question {
    private String question; // The text of the question
    private ArrayList<String> answers; // List of all possible answers
    private String rAnswer; // The correct answer

    /**
     * Initializes a new Question object with the given text and answers.
     * The first answer is always the correct answer, and all answers are shuffled
     * to randomize their display order.
     *
     * @param q The text of the question.
     * @param a1 The correct answer.
     * @param a2 The first incorrect answer.
     * @param a3 The second incorrect answer.
     * @param a4 The third incorrect answer.
     */
    public Question(String q, String a1, String a2, String a3, String a4) {
        question = q;
        answers = new ArrayList<>();
        answers.add(a1);
        answers.add(a2);
        answers.add(a3);
        answers.add(a4);
        rAnswer = a1; // The first answer is marked as correct
        getShuffleAnswer(); // Shuffle the answers for randomized order
    }

    /**
     * Retrieves the question text.
     *
     * @return The text of the question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Retrieves the correct answer.
     *
     * @return The correct answer as a string.
     */
    public String getRightAnswer() {
        return rAnswer;
    }

    /**
     * Retrieves the list of all possible answers.
     *
     * @return An ArrayList containing all answers.
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }

    /**
     * Randomizes the order of the possible answers.
     */
    public void getShuffleAnswer() {
        Collections.shuffle(answers);
    }

    /**
     * Retrieves the first answer in the randomized list.
     *
     * @return The first answer.
     */
    public String getAnswer1() {
        return answers.get(0);
    }

    /**
     * Retrieves the second answer in the randomized list.
     *
     * @return The second answer.
     */
    public String getAnswer2() {
        return answers.get(1);
    }

    /**
     * Retrieves the third answer in the randomized list.
     *
     * @return The third answer.
     */
    public String getAnswer3() {
        return answers.get(2);
    }

    /**
     * Retrieves the fourth answer in the randomized list.
     *
     * @return The fourth answer.
     */
    public String getAnswer4() {
        return answers.get(3);
    }
}
