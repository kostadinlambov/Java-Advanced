import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class p08_Matrix_shuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixDimensions = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = reader.readLine().split(" ");
        }

        String inputLine = reader.readLine();

        while (!inputLine.equals("END")) {

            String[] tokens = inputLine.split(" ");
            String command = tokens[0];

            if (tokens.length == 5 && command.equals("swap")) {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                boolean row1Valid = row1 < matrix.length && row1 >= 0;
                boolean col1Valid = col1 < matrix[0].length && col1 >= 0;
                boolean row2Valid = row2 < matrix.length && row2 >= 0;
                boolean col2Valid = col2 < matrix[0].length && col2 >= 0;

                if (row1Valid && col1Valid && row2Valid && col2Valid) {

                    //swapMatrixCells(matrix, row1, col1, row2, col2);
                    String oldFirstRowValue = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = oldFirstRowValue;

                    for (String[] aMatrix : matrix) {
                        System.out.println(Arrays.toString(aMatrix)
                                .replace("[", "")
                                .replace("]", "")
                                .replace(",", ""));
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            inputLine = reader.readLine();
        }
    }

    private static void swapMatrixCells(String[][] matrix, int row1, int col1, int row2, int col2) {
        String oldFirstRowValue = matrix[row1][col1];
        String newFirsttRowValue = matrix[row2][col2];

        matrix[row1][col1] = newFirsttRowValue;
        matrix[row2][col2] = oldFirstRowValue;

        //printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            String[] aMatrix = matrix[i];
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%s ", aMatrix[col]);
            }
            System.out.println();
        }
    }
}
