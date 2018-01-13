import java.util.Scanner;

public class p03_Diagonal_Difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        int rows = dimensions;
        int cols = dimensions;

        int[][] matrix = new int[rows][cols];

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int row = 0; row < rows; row++) {
            String[] reminder = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[col][row] = Integer.parseInt(reminder[col]);
                if (row == col) {
                    primaryDiagonalSum += matrix[col][row];
                }
                if (row == (cols - 1 - col)) {
                    secondaryDiagonalSum += matrix[col][row];
                }
            }
        }

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }
}
