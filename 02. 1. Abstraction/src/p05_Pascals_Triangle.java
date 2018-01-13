import java.util.Scanner;

public class p05_Pascals_Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long[][] pascalTriangle = new long[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                if ((row  > 0) && (col  > 0) && (pascalTriangle[row - 1][col] != 0)) {
                    pascalTriangle[row][col] = pascalTriangle[row - 1][col - 1] + pascalTriangle[row - 1][col];
                } else {
                    pascalTriangle[row][col] = 1;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.printf("%d ", pascalTriangle[row][col]);
            }
            System.out.println();
        }
    }
}
