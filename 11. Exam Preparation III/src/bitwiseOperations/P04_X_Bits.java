package bitwiseOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04_X_Bits {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = 8;
        int cols = 32;

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int currentNumber = Integer.parseInt(reader.readLine());
            String currentNumberBinary = String.format("%32s", Integer.toBinaryString(currentNumber))
                    .replace(" ", "0");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(currentNumberBinary.charAt(col) + "");

            }
        }

        int matchCouunter = 0;
        for (int row = 0; row < rows -2; row ++) {
            for (int col = 0; col < cols-2 ; col++) {
                boolean firstRowCondition = matrix[row][col] == 1 && matrix[row][col + 1] == 0
                        && matrix[row][col + 2] == 1;
                boolean secondRowCondition = matrix[row + 1][col] == 0 && matrix[row + 1][col + 1] == 1
                        && matrix[row + 1][col + 2] == 0;
                boolean thirdRowCondition = matrix[row + 2][col] == 1 && matrix[row + 2][col + 1] == 0
                        && matrix[row + 2][col + 2] == 1;
                if (firstRowCondition && secondRowCondition && thirdRowCondition) {
                    matchCouunter++;
                }
            }
        }

        System.out.println(matchCouunter);
    }
}
