public class ZeroMatrix {

    // Write an algorithm such that if an element in an N*N matrix is 0, its entire row and col are set to 0

    public void setZeros(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        // find zero row and col
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        // set them zero
        for (int i = 0; i < n; i++) {
            if (row[i]) {
                setZeros(matrix, i, -1);
            }
        }
        for (int i = 0; i < m; i++) {
            if (col[i]) {
                setZeros(matrix, -1, i);
            }
        }
    }

    private void setZeros(int[][] matrix, int row, int col) {
        if (col == -1) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
        if (row == -1) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

}
