import java.util.Scanner;
public class TicTacToe {
    // Create a 2D array to represent the game board
    private static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    // The current player (X or O)
    private static char currentPlayer = 'X';
    // Create the main method to start the game
    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        boolean gameWon = false;
        int moves = 0;
        // The game loop continues until the game is won or the board is full
        while (!gameWon && moves < 9) {
            // Print the current state of the board
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column: 1-3 1-3): ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            // If the move is valid, update the board and switch the current player
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            // The player makes their move
            board[row][col] = currentPlayer;
            moves++;
            // The game is won if there is a row, column, or diagonal with the same symbol
            if (checkWin()) {
                gameWon = true;
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
            } else if (moves == 9) {
                printBoard();
                System.out.println("It's a draw!");
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
    // Create a method to print the current state of the board
    private static void printBoard() {
        System.out.println("  1 2 3");
        // The outer loop iterates over the rows of the board
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            // The inner loop iterates over the columns of the board
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                // If it's not the last column, print a space
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }
    // The method to check if the game is won
    private static boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            // The game is won if all elements are the same
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        // The game is won if the diagonal elements are the same
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;
        return false; // The game is not won
    }
}
