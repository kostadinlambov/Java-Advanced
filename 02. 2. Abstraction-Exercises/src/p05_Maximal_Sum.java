import java.util.Arrays;
import java.util.Scanner;

public class p05_Maximal_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] reminder = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(reminder[col]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int maxSumRow = 0;
        int maxSumCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    maxSumRow = row;
                    maxSumCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);

        for (int row = maxSumRow; row < maxSumRow + 3; row++) {
            for (int col = maxSumCol; col < maxSumCol + 3; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
