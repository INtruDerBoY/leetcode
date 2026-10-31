class Solution {
    private char[][] board; 
    private int rows; 
    private int cols;

   
    public void solve(char[][] board) {
        rows = board.length; 
        cols = board[0].length; 
        this.board = board; 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    depthFirstSearch(i, j);
                }
            }
        }

    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                }
                
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    
    private void depthFirstSearch(int row, int col) {
        board[row][col] = 'W'; 
        int[] directions = {-1, 0, 1, 0, -1}; 
        for (int k = 0; k < 4; k++) { 
            int nextRow = row + directions[k];
            int nextCol = col + directions[k + 1];
           
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && board[nextRow][nextCol] == 'O') {
                depthFirstSearch(nextRow, nextCol); 
            }
        }
    }
}