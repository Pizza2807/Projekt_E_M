package org.example;
import java.util.Arrays;

public class Board {

    char[][] cells;

    public Board() {
        this.cells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(cells[i], ' ');
        }
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(cells[i], ' ');
        }
    }

    @Override
    public String toString() {
        return "Board: " + "\n" +
                " " + cells[0][0] + " | " + cells[0][1] + " | " + cells[0][2] + "\n" +
                "---|---|---\n" +
                " " + cells[1][0] + " | " + cells[1][1] + " | " + cells[1][2] + "\n" +
                "---|---|---\n" +
                " " + cells[2][0] + " | " + cells[2][1] + " | " + cells[2][2];
    }
}

