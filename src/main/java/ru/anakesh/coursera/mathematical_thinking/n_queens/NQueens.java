package ru.anakesh.coursera.mathematical_thinking.n_queens;

public class NQueens {

    public int[] findSolution(int n) {
        if (n < 4) return null;
        int[] rowToCol = new int[n];
        return findSolutionRecursive(0, rowToCol);
    }

    private int[] findSolutionRecursive(int currentRow, int[] rowToCol) {
        for (int i = 0; i < rowToCol.length; i++) {
            if (isValid(currentRow, i, rowToCol)) {
                rowToCol[currentRow] = i;
                if (currentRow == rowToCol.length - 1) {
                    return rowToCol;
                } else {
                    int[] solution = findSolutionRecursive(currentRow + 1, rowToCol);
                    if (solution != null)
                        return solution;
                }
            }
        }
        return null;
    }

    private boolean isValid(int row, int possibleValue, int[] rowToCol) {
        for (int i = 0; i < row; i++) {
            if (rowToCol[i] == possibleValue || Math.abs(i - row) == Math.abs(rowToCol[i] - possibleValue))
                return false;
        }
        return true;
    }
}
