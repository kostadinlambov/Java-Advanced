import java.util.Arrays;
import java.util.Scanner;

public class p04_2x2_Squares_in_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] reminder = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = reminder[col].charAt(0);
            }
        }

        int count = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if (matrix[row][col] == matrix[row][col + 1] &&
                        matrix[row][col] == matrix[row + 1][col] &&
                        matrix[row][col] == matrix[row + 1][col + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
