package TicTacToeGame;

import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            { '-', '-', '-' },
            { '-', '-', '-' },
            { '-', '-', '-' }
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean gameEnded = false;
        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + ", enter your move (row[0-2] and column[0-2]): ");
            int row = sc.nextInt();
            int column = sc.nextInt();

            if (row < 0 || row > 2 || column < 0 || column > 2 || board[row][column] != '-') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            // Inserting Current Player Symbol
            board[row][column] = currentPlayer;
            printBoard();

            if (hasWinner()) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                System.out.println("The game is a draw!");
                gameEnded = true;
            } else {
                // Switching players
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }

        }

    }

    // Printing board in console
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Checking the board is any dashs(-) or not
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // checking conditions
    static boolean hasWinner() {
        // checking Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        // checking Columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
                return true;
            }
        }
        // checking Diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;

    }
}
