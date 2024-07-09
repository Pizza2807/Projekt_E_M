package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private Scanner scanner;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }

    public void start() {
        resetGame();
        while (true) {
            board.print();
            displayCurrentTurn();
            int x = getInput("Enter x coordinate: ");
            int y = getInput("Enter y coordinate: ");
            if (board.isCellEmpty(x, y)) {
                board.place(x, y, currentPlayer.getMarker());
                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    if (playAgain()) {
                        resetGame();
                    } else {
                        break;
                    }
                } else if (board.isFull()) {
                    board.print();
                    System.out.println("It's a draw!");
                    if (playAgain()) {
                        resetGame();
                    } else {
                        break;
                    }
                } else {
                    switchCurrentPlayer();
                }
            } else {
                System.out.println("Cell is already occupied. Try again!");
            }
        }
    }

    private void displayCurrentTurn() {
        System.out.println("It's " + currentPlayer.getMarker() + "'s turn.");
    }


    private void resetGame() {
        board.clear();
        currentPlayer = player1;
    }

    private boolean playAgain() {
        System.out.println("Do you want to play again? (yes/no)");
        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }


    private boolean hasWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board.cells[i][0] == board.cells[i][1] && board.cells[i][1] == board.cells[i][2] && board.cells[i][0]!= '-') {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board.cells[0][i] == board.cells[1][i] && board.cells[1][i] == board.cells[2][i] && board.cells[0][i]!= '-') {
                return true;
            }
        }

        // Check diagonals
        if ((board.cells[0][0] == board.cells[1][1] && board.cells[1][1] == board.cells[2][2] && board.cells[0][0]!= '-')
                || (board.cells[0][2] == board.cells[1][1] && board.cells[1][1] == board.cells[2][0] && board.cells[0][2]!= '-')) {
            return true;
        }

        return false;
    }

    private int getInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = scanner.nextInt();
                if (input < 0 || input > 2) {
                    System.out.println("Invalid input. Please enter a number between 0 and 2.");
                } else {
                    return input;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // discard invalid input
            }
        }
    }
}