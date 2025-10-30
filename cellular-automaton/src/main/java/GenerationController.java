import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Controller for the Conway's Game of Life simulation.
 * Manages user interaction and updates the grid on the Canvas.
 */
public class GenerationController {

    @FXML
    private Canvas canva; // Canvas for displaying the grid.

    private GraphicsContext gc; // Graphics context for drawing.
    private int SIZE; // Size of each grid cell in pixels.
    private final int MAT_SIZE = 10; // Size of the grid (10x10 cells).

    private Generation generation = new Generation(); // Manages the game's logic.

    /**
     * Initializes the Canvas and calculates cell size.
     */
    public void initialize() {
        gc = canva.getGraphicsContext2D();
        SIZE = (int) (canva.getHeight() / MAT_SIZE);
    }

    /**
     * Advances the simulation to the next generation, updates the grid, and redraws it.
     *
     * @param event ActionEvent triggered by clicking the "Next Generation" button.
     */
    @FXML
    void nextGeneration(ActionEvent event) {
        gc.clearRect(0, 0, canva.getWidth(), canva.getHeight());
        for (int i = 0; i < MAT_SIZE; i++) {
            for (int j = 0; j < MAT_SIZE; j++) {
                gc.strokeRect(i * SIZE, j * SIZE, SIZE, SIZE);
                if (generation.getCell(i, j)) {
                    gc.setFill(Color.BLUE);
                    gc.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);
                } else {
                    gc.setFill(Color.GRAY);
                    gc.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);
                }
            }
        }

        boolean[][] tempMat = new boolean[MAT_SIZE][MAT_SIZE];
        generation.copyMat(tempMat);

        for (int i = 0; i < MAT_SIZE; i++) {
            for (int j = 0; j < MAT_SIZE; j++) {
                generation.setCell(generation.changeCell(i, j, tempMat), i, j);
            }
        }
    }
}
