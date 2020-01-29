import java.util.Arrays;

public class RotateMatrix {

    // Given an image represented by an N*N matrix, where each pixel in the image is represented by an
    // integer, write a method to rotate the image by 90 degrees. Do it in place.

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2) {
            return;
        }
        int round = n / 2;
        for (int level = 0; level < round; level++) {
            int left = 0;
            int right = n - 1 - level;
            for (int i = left; i < right; i++) {
                // offset number
                int offset = i - left;
                // save top
                int tmp = matrix[left][i];
                // left bottom to top left
                matrix[left][i] = matrix[right - offset][left];
                // right bottom to left bottom
                matrix[right - offset][left] = matrix[right][right - offset];
                // top right = bottom right
                matrix[right][right - offset] = matrix[i][right];
                // top left to top right
                matrix[i][right] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateMatrix sol = new RotateMatrix();
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        printMatrix(mat);
        sol.rotate(mat);
        printMatrix(mat);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Matrix is: ");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
