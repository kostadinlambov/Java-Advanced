package p05_Java_Advanced_Exam_19_June_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_Cubics_Rube {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        long[][][] matrix = new long[n][n][n];

        long totalSum = 0L;
        while (true) {
            String[] tokens = reader.readLine().split(" ");
            if ("Analyze".equals(tokens[0])) {
                break;
            }

            int firstDimension = Integer.parseInt(tokens[0]);
            int secondDimension = Integer.parseInt(tokens[1]);
            int thirdDimension = Integer.parseInt(tokens[2]);

            int particles = Integer.parseInt(tokens[3]);

            if (firstDimension < n && secondDimension < n && thirdDimension < n &&
                    firstDimension >= 0 && secondDimension >= 0 && thirdDimension >= 0) {
                matrix[firstDimension][secondDimension][thirdDimension] += particles;
                totalSum += particles;
            }
        }

        long numberOFCellsWithNoValue = 0L;
        long totalSum2 = 0L;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (matrix[i][j][k] == 0) {
                        numberOFCellsWithNoValue++;
                    } else {
                        totalSum2 += matrix[i][j][k];
                    }
                }
            }
        }

        System.out.println(totalSum);
        System.out.println(numberOFCellsWithNoValue);
    }
}
