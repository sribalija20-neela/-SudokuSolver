public class SudokuSolverApp {

    // Size of the Sudoku grid
    private static final int SIZE = 9;

    public static void main(String[] args) {
        // 0 represents an empty cell in the puzzle
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("=== Unsolved Sudoku Board ===");
        printBoard(board);

        // Core Algorithm: Backtracking (Depth-First Search simulation)
        if (solveSudoku(board)) {
            System.out.println("\n✅ Solved Successfully by Backtracking Algorithm:");
            printBoard(board);
        } else {
            System.out.println("\n❌ This puzzle cannot be solved.");
        }
    }

    // 1. Algorithmic Pattern: Backtracking (Recursion)
    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) { // Found an empty cell
                    for (int number = 1; number <= SIZE; number++) {
                        if (isValid(board, row, col, number)) {
                            board[row][col] = number; // Place number (Hypothesis)

                            if (solveSudoku(board)) { // Recursive call
                                return true;
                            }

                            board[row][col] = 0; // Undo placement (Backtrack)
                        }
                    }
                    return false; // Triggers back-tracking step
                }
            }
        }
        return true; // All cells filled successfully
    }

    // 2. Data Structure Logic: Grid Validation checks in O(1) space auxiliary matrix logic
    private static boolean isValid(int[][] board, int row, int col, int number) {
        // Check the row
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number) return false;
        }

        // Check the column
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == number) return false;
        }

        // Check the local 3x3 box
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board[i][j] == number) return false;
            }
        }

        return true; 
    }

    // Helper method to display grid layout beautifully in console
    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("---------------------");
            }
            for (int col = 0; col < SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[row][col] == 0 ? ". " : board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
