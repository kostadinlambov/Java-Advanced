import java.util.Arrays;
import java.util.Scanner;

public class p02_Matrix_of_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        fillTheMatrix(rows, cols);
    }

    private static void fillTheMatrix(int rows, int cols) {

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = ((char) ('a' + row) + "")
                        + ((char) ('a' + col + row) + "")
                        + ((char) ('a' + row) + "");
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
