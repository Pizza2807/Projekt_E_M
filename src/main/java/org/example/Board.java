package org.example;
import java.util.Arrays;


class Board {
    char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '-';
            }
        }
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '-';
    }

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }
}
