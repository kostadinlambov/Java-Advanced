import java.util.Arrays;
import java.util.Scanner;

public class p04_Maximum_Sum_of_2x2_Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] reminder = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(reminder[col]);
            }
        }

        System.out.println();
        int maxSum = Integer.MIN_VALUE;
        int maxSumRow = 0;
        int maxSumCol = 0;
        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < cols-1; col++) {
                int sum = matrix[row][col] + matrix[row][col+1]+
                        matrix[row+1][col] + matrix[row+1][col+1];

                if(sum > maxSum){
                    maxSum = sum;
                    maxSumRow = row;
                    maxSumCol = col;
                }
            }
        }

        for (int row = maxSumRow; row <= maxSumRow+1; row++) {
            for (int col = maxSumCol; col <= maxSumCol + 1; col++) {
                System.out.printf("%d ",matrix[row][col]);
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
