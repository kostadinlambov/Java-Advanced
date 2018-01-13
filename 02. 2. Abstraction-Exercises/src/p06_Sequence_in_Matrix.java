import java.util.Arrays;
import java.util.Scanner;

public class p06_Sequence_in_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] reminder = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = reminder[col];
            }
        }

        if(cols == 1 && rows == 1){
            System.out.println(matrix[0][0]);
            return;
        }

        int count = 1;
        int maxCount = 1;
        String maxCountValue = matrix[0][0];
        String maxIndex1String = "0";

        // Check Rows

        for (int row = 0; row < rows; row++) {
            count = 1;
            for (int col = 0; col < cols -1; col++) {

                if (matrix[row][col].equals(matrix[row][col + 1])) {
                    count++;

                    if (count >= maxCount) {
                        maxCount = count;
                        maxCountValue = matrix[row][col];
                        maxIndex1String = row + col + "";
                    }
                } else {
                    count = 1;
                }
            }
        }

        int maxCountIndex = Integer.parseInt(maxIndex1String);

        // Check Columns

        int maxCountIndex2 = 0;

        for (int col = 0; col < cols; col++) {
            count = 1;
            for (int row = 0; row < rows - 1; row++) {
                if (matrix[row][col].equals(matrix[row + 1][col])) {
                    count++;
                    maxIndex1String = row + col + "";
                    maxCountIndex2 = Integer.parseInt(maxIndex1String);
                    if (count > maxCount) {
                        maxCount = count;
                        maxCountValue = matrix[row][col];
                    } else if (maxCountIndex2 > maxCountIndex && count == maxCount) {
                        maxCount = count;
                        maxCountValue = matrix[row][col];
                    }
                } else {
                    count = 1;
                }
            }
        }

        // Check Diagonal

        int maxCountIndex3 = 0;

        int length = Math.min(matrix.length, matrix[1].length);

        for (int row = 0; row < rows - 1; row++) {
            count = 0;
            for (int col = 0; col < cols - 1; col++) {
                String tempMajor = matrix[row][col];        // all elements in the Major must be equal to this
                count = 0;
                for (int i = 0; i < length; i++) {
                    if (i + row < rows && i + col < cols) {
                        if (matrix[i + row][i + col].equals(tempMajor)) {
                            count++;
                            maxIndex1String = row + col + "";
                            maxCountIndex3 = Integer.parseInt(maxIndex1String);
                            if (count > maxCount) {
                                maxCount = count;
                                maxCountValue = matrix[i][i];
                            } else if (maxCountIndex3 > maxCountIndex && count == maxCount) {
                                maxCount = count;
                                maxCountValue = matrix[i][i];
                            }
                        } else {
                            count = 0;
                            break;
                        }
                    }
                }
            }
        }

        String[] result = new String[maxCount];
        for (int i = 0; i < maxCount; i++) {
            result[i] = maxCountValue;
        }

        System.out.println(String.join(", ", result));
    }
}
