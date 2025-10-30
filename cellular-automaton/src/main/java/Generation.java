import java.util.Random;

/**
 * Manages the logic for Conway's Game of Life.
 * Tracks the grid state and applies the rules to compute the next generation.
 */
public class Generation {
    private boolean[][] lifeMat; // Current state of the grid.
    private final int SIZE_MAT = 10; // Size of the grid (10x10 cells).

    /**
     * Initializes the grid with random cell states.
     */
    public Generation() {
        lifeMat = new boolean[SIZE_MAT][SIZE_MAT];
        FillMat(lifeMat);
    }

    /**
     * Fills the grid with random values (true for alive, false for dead).
     *
     * @param mat The matrix to populate.
     */
    private void FillMat(boolean[][] mat) {
        Random random = new Random();
        for (int i = 0; i < SIZE_MAT; i++) {
            for (int j = 0; j < SIZE_MAT; j++) {
                mat[i][j] = random.nextBoolean();
            }
        }
    }

    /**
     * Copies the current grid state into a new matrix.
     *
     * @param newGen The matrix to copy into.
     * @return The copied matrix.
     */
    public boolean[][] copyMat(boolean[][] newGen) {
        for (int i = 0; i < SIZE_MAT; i++) {
            for (int j = 0; j < SIZE_MAT; j++) {
                newGen[i][j] = this.lifeMat[i][j];
            }
        }
        return newGen;
    }

    /**
     * Retrieves the current state of a specific cell.
     *
     * @param i Row index of the cell.
     * @param j Column index of the cell.
     * @return True if the cell is alive, false otherwise.
     */
    public boolean getCell(int i, int j) {
        return lifeMat[i][j];
    }

    /**
     * Updates the state of a specific cell.
     *
     * @param cell New state of the cell (true for alive, false for dead).
     * @param i    Row index of the cell.
     * @param j    Column index of the cell.
     */
    public void setCell(boolean cell, int i, int j) {
        this.lifeMat[i][j] = cell;
    }

    /**
     * Applies Conway's rules to determine the next state of a specific cell.
     *
     * @param i   Row index of the cell.
     * @param j   Column index of the cell.
     * @param mat Current grid state.
     * @return The cell's state in the next generation.
     */
    public boolean changeCell(int i, int j, boolean[][] mat) {
        int live = 0;

        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && x < SIZE_MAT && y >= 0 && y < SIZE_MAT && !(x == i && y == j)) {
                    if (mat[x][y]) {
                        live++;
                    }
                }
            }
        }

        boolean state = mat[i][j];

        if (state) {
            if (live < 2 || live > 3) {
                state = false;
            }
        } else {
            if (live == 3) {
                state = true;
            }
        }

        return state;
    }
}
