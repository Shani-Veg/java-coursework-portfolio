import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * Controller class for managing the Trivia Game logic and UI interactions.
 * Handles user inputs, game state updates, and interactions with the Trivia and Question classes.
 */
public class ProjectController {

    // UI elements for managing question answers and displaying game status
    @FXML
    private ToggleGroup answer; // Group for radio buttons representing the answers

    @FXML
    private RadioButton answer1; // First answer option
    @FXML
    private RadioButton answer2; // Second answer option
    @FXML
    private RadioButton answer3; // Third answer option
    @FXML
    private RadioButton answer4; // Fourth answer option

    @FXML
    private TextField question; // TextField for displaying the question text

    @FXML
    private TextField comments; // TextField for displaying game messages or feedback

    // Game state and logic variables
    private boolean keepPlaying = true; // Tracks whether the game is active
    private Trivia trivia = new Trivia(); // The Trivia object managing game questions and scores
    Question currentQuestion; // Stores the current question being displayed
    final private int GET_10_POINTS = 10; // Points awarded for a correct answer
    final private int LOSE_5_POINT = -5; // Points deducted for an incorrect answer

    /**
     * Event handler for the "OK" button. Processes the user's answer and updates the game state.
     * @param event The ActionEvent triggered when the "OK" button is pressed.
     */
    @FXML
    void OKPress(ActionEvent event) {
        if (keepPlaying) {
            RadioButton selectButton = (RadioButton) answer.getSelectedToggle();
            if (selectButton != null) {
                String answerPress = selectButton.getText();
                // Check if the selected answer is correct
                if (currentQuestion.getRightAnswer().equals(answerPress)) {
                    trivia.setScore(trivia.getScore() + GET_10_POINTS);
                    comments.setText("Correct answer :) You got 10 points!! Next question:");
                } else {
                    trivia.setScore(trivia.getScore() + LOSE_5_POINT);
                    comments.setText("Wrong answer :( You lost 5 points. Next question:");
                }
                answer.selectToggle(null); // Clear selection
                trivia.setIndex();
                showNextQuestion(); // Display the next question
            } else {
                comments.setText("Please select an answer."); // Prompt to select an answer
            }
        }
    }

    // Placeholder methods for individual answer button presses
    @FXML
    void answer1Press(ActionEvent event) {}

    @FXML
    void answer2Press(ActionEvent event) {}

    @FXML
    void answer3Press(ActionEvent event) {}

    @FXML
    void answer4Press(ActionEvent event) {}

    /**
     * Event handler for the "End Game" button. Ends the game and displays the final score.
     * @param event The ActionEvent triggered when the button is pressed.
     */
    @FXML
    void endGmePress(ActionEvent event) {
        gameOver();
    }

    /**
     * Event handler for the "Start Game" button. Initializes and starts a new game.
     * @param event The ActionEvent triggered when the button is pressed.
     */
    @FXML
    void startGamePress(ActionEvent event) {
        keepPlaying = true;
        comments.setText("First Question");
        trivia.setIndexToStartGame();
        trivia.shuffleQuestions();
        showNextQuestion();
        trivia.setScore(0);
    }

    /**
     * Displays the next question or ends the game if no questions remain.
     */
    private void showNextQuestion() {
        if (trivia.getIndex() == trivia.getTriviaLength()) {
            gameOver();
        } else if (keepPlaying) {
            currentQuestion = trivia.getNewQuestion();
            question.setText(currentQuestion.getQuestion());
            answer1.setText(currentQuestion.getAnswer1());
            answer2.setText(currentQuestion.getAnswer2());
            answer3.setText(currentQuestion.getAnswer3());
            answer4.setText(currentQuestion.getAnswer4());
        } else {
            question.setText("Game Over!");
            answer1.setText("");
            answer2.setText("");
            answer3.setText("");
            answer4.setText("");
        }
    }

    /**
     * Ends the game and displays the player's score and a game-over message.
     */
    private void gameOver() {
        keepPlaying = false;
        question.setText("Game Over! If you want to play again, press Start Game.");
        answer1.setText("");
        answer2.setText("");
        answer3.setText("");
        answer4.setText("");
        comments.setText("Your score is " + trivia.getScore() + ", good job!");
    }
}
