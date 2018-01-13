import java.util.Scanner;

public class p07_Letters_Change_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double totalSum = 0;

        for (int i = 0; i < input.length; i++) {
            char firstLetter = input[i].charAt(0);
            char secondLetter = input[i].charAt(input[i].length() - 1);
            double number = Double.parseDouble(input[i].substring(1, input[i].length() - 1));

            double sum = calculateSum(firstLetter, secondLetter, number);

            totalSum += sum;
        }

        System.out.printf("%.2f", totalSum);

    }

    private static double calculateSum(char firstLetter, char secondLetter, double number) {

        double sum = 0;
        if (Character.isUpperCase(firstLetter)) {
            sum = number / (firstLetter - 'A' + 1);
        } else {
            sum = number * (firstLetter - 'a' + 1);
        }

        if (Character.isUpperCase(secondLetter)) {
            sum -= (secondLetter - 'A' + 1);
        } else {
            sum += (secondLetter - 'a' + 1);
        }

        return sum;
    }
}
