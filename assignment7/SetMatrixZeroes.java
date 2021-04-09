package assignment7;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        Set<Integer> rowsContains0 = new HashSet<>();
        Set<Integer> colsContains0 = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsContains0.add(i);
                    colsContains0.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowsContains0.contains(i)) {
                    matrix[i][j] = 0;
                }
                if (colsContains0.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
