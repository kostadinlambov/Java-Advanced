import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p06_Sequence_in_Matrix_Second_Version {
    private static List<String> finalResult = new ArrayList<>();
    private static List<String> tempResult = new ArrayList<>();

    public static void main(String[] args) {
        // Read input and fill the matrix
        Scanner scan = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];
    for (int i = 0; i < matrixSize[0]; i++) {
            String[] line = scan.nextLine().split("\\s+");
            matrix[i] = line;
        }
        // Check all possible sequences
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                tryDiagonal(matrix, i, j);
                tryRow(matrix, i, j);
            }
        }
        // Print output
        System.out.println(finalResult.toString().replaceAll("[\\[\\]]",""));
    }

    private static void tryDiagonal(String[][] matrix, int row, int col) {
        tempResult.clear();
        tempResult.add(matrix[row][col].toUpperCase());
        for (int k = row; k < Math.min(matrix.length-1,matrix[row].length-1); k++) {
            if(matrix[k][k].equals(matrix[k+1][k+1])){
                tempResult.add(matrix[k][k]);
            } else {
                break;
            }
        }
        checkIsCurrentSequenceLongest();
    }

    private static void tryRow(String[][] matrix, int row, int col) {
        tempResult.clear();
        tempResult.add(matrix[row][col].toUpperCase());
        for (int i = row; i < matrix.length - 1; i++) {
            if(matrix[i][col].equals(matrix[i+1][col])) {
                tempResult.add(matrix[i][col].toUpperCase());
            } else {
                break;
            }
        }
        checkIsCurrentSequenceLongest();
    }

    private static void checkIsCurrentSequenceLongest() {
        if(tempResult.size() >= finalResult.size()) {
            finalResult.clear();
            for (String aTempResult : tempResult) {
                finalResult.add(aTempResult.toLowerCase());
            }
        }
    }
}
