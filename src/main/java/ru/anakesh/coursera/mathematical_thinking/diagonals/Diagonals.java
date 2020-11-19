package ru.anakesh.coursera.mathematical_thinking.diagonals;

public class Diagonals {
    private final int n;
    private final int maxIndex;

    public Diagonals(int n) {
        this.n = n;
        this.maxIndex = (n * n);
    }

    public String[][] placeDiagonals(int numOfDiagonals) {
        int[] ints = new int[n * n];
        int[] field = putNewDiagonal(numOfDiagonals, 0, ints);
        if (field == null) {
            return null;
        }
        return mapPretty(field);
    }

    private int[] putNewDiagonal(int diagonalsToPut, int currentIndex, int[] field) {
        if (currentIndex == maxIndex) {
            if (diagonalsToPut == 0) {
                return field;
            } else {
                return null;
            }
        }
        for (int i = -1; i <= 1; i++) {
            if (!conflicts(currentIndex, i, field)) {
                field[currentIndex] = i;
                int remain = diagonalsToPut;
                if (i != 0) {
                    remain--;
                }
                int[] solution = putNewDiagonal(remain, currentIndex + 1, field);
                if (solution != null)
                    return solution;
            }
        }
        return null;
    }

    private boolean conflicts(int index, int possibleDiagonal, int[] field) {
        if (possibleDiagonal == 0)
            return false;
        if (index % n > 0 && (field[index - 1] == -possibleDiagonal)) {
            return true;
        }
        if (index / n > 0) {
            if (field[index - n] == -possibleDiagonal) {
                return true;
            }
            if (possibleDiagonal == 1 && index % n > 0 && field[index - 1 - n] != -possibleDiagonal) {
                return true;
            }
            return possibleDiagonal == -1 && index % n < (n - 1) && field[index + 1 - n] != -possibleDiagonal;
        }
        return false;
    }

    private String[][] mapPretty(int[] field) {
        String[][] prettyField = new String[n][n];
        for (int i = 0; i < field.length; i++) {
            String d;
            switch (field[i]) {
                case -1: {
                    d = "\\";
                    break;
                }
                case 1: {
                    d = "/";
                    break;
                }
                default:
                    d = " ";
            }
            prettyField[i / n][i % n] = d;
        }
        return prettyField;
    }
}
