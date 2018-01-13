import java.util.Scanner;

public class p01_Fill_the_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(commands[0]);
        int cols = Integer.parseInt(commands[0]);

        String pattern = commands[1];

        if (pattern.equals("A")) {
            fillMatrixPatterA(rows, cols);
        } else if (pattern.equals("B")) {
            fillMatrixPatterB(rows, cols);
        }
    }

    private static void fillMatrixPatterB(int rows, int cols) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[rows][cols];

        int matrixCellValue = 1;
        for (int col = 0; col < cols; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = matrixCellValue;
                    matrixCellValue++;
                }
            }else{
                for (int row = rows-1; row >= 0; row--) {
                    matrix[row][col] = matrixCellValue;
                    matrixCellValue++;
                }
            }
        }

        printMatrix(matrix);
    }

    private static void fillMatrixPatterA(int rows, int cols) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[rows][cols];

        int matrixCellValue = 1;
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                matrix[row][col] = matrixCellValue;
                matrixCellValue++;
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
