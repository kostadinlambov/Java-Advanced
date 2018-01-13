import java.util.Arrays;
import java.util.Scanner;

public class p13_Blur_Filter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurAmount = Integer.parseInt(scanner.nextLine());

        String[] rowsColsNumber = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(rowsColsNumber[0]);
        int cols = Integer.parseInt(rowsColsNumber[1]);

        long[][] matrix = new long[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Long.parseLong(input[col]);
            }
        }

        String[] blurCoordinates = scanner.nextLine().split("\\s+");
        int targetRow = Integer.parseInt(blurCoordinates[0]);
        int targetCol = Integer.parseInt(blurCoordinates[1]);

        int left = Math.max(0, targetCol - 1);
        int right = Math.min(targetCol + 1, cols);
        int top = Math.max(targetRow - 1, 0);
        int bottom = Math.min(targetRow + 1, rows);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if((left <= col && col <= right) && (top <= row && row <= bottom)){
                    System.out.printf("%d ",matrix[row][col] + blurAmount );
                }else{
                    System.out.printf("%d ",matrix[row][col]);
                }
            }

            System.out.println();
        }
    }
}
