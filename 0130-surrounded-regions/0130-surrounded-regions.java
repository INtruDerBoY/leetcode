class Solution {
    private char[][] board; // Member variable to hold the input board
    private int rows; // Number of rows in the board
    private int cols; // Number of columns in the board

    // Main function that solves the board by replacing all 'O' surrounded by 'X' with 'X'
    public void solve(char[][] board) {
        rows = board.length; // Set the number of rows
        cols = board[0].length; // Set the number of columns
        this.board = board; // Initialize the board member variable

        // Explore all 'O' on the borders, any 'O' connected to them should not be flipped
        // hence temporarily mark them with 'W'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Condition to check if it's on the border and if it's an 'O'
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    depthFirstSearch(i, j); // Call DFS to mark the connected 'O's
                }
            }
        }

        // Flip all remaining 'O' to 'X' and back all 'W' to 'O'.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If it was marked 'W', it's safe to flip it back to 'O'
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                }
                // If it's still an 'O', it should be flipped to 'X' as it is not connected to a border/water
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // Depth-first search function to find all the 'O's connected to a border 'O' (Water)
    private void depthFirstSearch(int row, int col) {
        board[row][col] = 'W'; // Mark the cell as visited by replacing 'O' with 'W'
        int[] directions = {-1, 0, 1, 0, -1}; // Directions to move in the matrix
        for (int k = 0; k < 4; k++) { // Loop through possible directions (up, right, down, left)
            int nextRow = row + directions[k];
            int nextCol = col + directions[k + 1];
            // Check bounds and if the next cell is 'O', continue DFS
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && board[nextRow][nextCol] == 'O') {
                depthFirstSearch(nextRow, nextCol); // Recursive call for connected 'O's
            }
        }
    }
}