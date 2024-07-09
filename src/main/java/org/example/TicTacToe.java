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
    }

    public void start() {
        while (true) {
            board.print();
            int x = getInput("Enter x coordinate: ");
            int y = getInput("Enter y coordinate: ");
            if (board.isCellEmpty(x, y)) {
                board.place(x, y, currentPlayer.getMarker());
            }



    private void displayCurrentTurn() {
        System.out.println("It's " + currentPlayer.getMarker() + "'s turn.");
    }



    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }


    private boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if (board.cells[i][0] == board.cells[i][1] && board.cells[i][1] == board.cells[i][2] && board.cells[i][0]!= '-') {
                return true;
            }
        }


        for (int i = 0; i < 3; i++) {
            if (board.cells[0][i] == board.cells[1][i] && board.cells[1][i] == board.cells[2][i] && board.cells[0][i]!= '-') {
                return true;
            }
        }


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
                scanner.next();
            }
        }
    }
}