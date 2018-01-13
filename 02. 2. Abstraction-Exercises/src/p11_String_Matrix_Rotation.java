import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p11_String_Matrix_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputCommand = scanner.nextLine();

        String regex = "\\d+";
        String str = inputCommand;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        String command = "";

        while (matcher.find()) {
            command = matcher.group(0);
        }

        List<String> inputList = new ArrayList<>();

        int maxInputLength = 0;
        while (true) {
            String input = scanner.nextLine();

            if (input.length() > maxInputLength) {
                maxInputLength = input.length();
            }

            if (input.equalsIgnoreCase("END")) {
                break;
            }

            inputList.add(input);
        }

        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).length() < maxInputLength) {
                for (int j = inputList.get(i).length(); j < maxInputLength; j++) {
                    inputList.set(i, inputList.get(i) + " ");
                }
            }
        }

        rotateMatrix(inputList, command);
    }

    private static void rotateMatrix(List<String> inputList, String command) {

        int commandInt = Integer.parseInt(command) % 360;

        if (commandInt == 90) {
            int rows = inputList.get(1).length();
            int cols = inputList.size();

            char[][] matrix = new char[rows][cols];

            for (int col = 0; col < cols; col++) {
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = inputList.get(cols - col - 1).charAt(row);
                }
            }

            printMatrix(matrix);

        } else if (commandInt == 180) {

            int rows = inputList.size();
            int cols = inputList.get(1).length();

            char[][] matrix = new char[rows][cols];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = inputList.get(rows -1 -row).charAt(cols - col - 1);
                }
            }

            printMatrix(matrix);

        }else if (commandInt == 270) {
            int rows = inputList.get(1).length();
            int cols = inputList.size();

            char[][] matrix = new char[rows][cols];

            for (int col = 0; col < cols; col++) {
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = inputList.get(col).charAt(rows - row - 1);
                }
            }

            printMatrix(matrix);

        }else{
            int rows = inputList.size();
            int cols = inputList.get(1).length();

            char[][] matrix = new char[rows][cols];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = inputList.get(row).charAt(col);
                }
            }

            printMatrix(matrix);
        }
    }

    private static void printMatrix(char[][] matrix) {
        int rows = matrix.length;

        for (int row = 0; row < rows; row++) {
            System.out.println(new String(matrix[row]));
        }
    }
}
