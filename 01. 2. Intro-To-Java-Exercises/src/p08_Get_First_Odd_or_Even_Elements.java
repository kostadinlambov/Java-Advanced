import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p08_Get_First_Odd_or_Even_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Scanner input = new Scanner(System.in);

        String[] inputNumbers = input.nextLine().split(" ");
        String[] commands = input.nextLine().split(" ");

        int[] numbers = new int[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        ArrayList<Integer> resultNumbers = getFirstEvenOrOddNumbers(numbers, commands);
        resultNumbers.forEach(n -> System.out.print(n + " "));
    }

    public static ArrayList<Integer> getFirstEvenOrOddNumbers(int[] numbers, String[] commands) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < numbers.length && numbersList.size() < Integer.parseInt(commands[1]); i++) {
            if (numbers[i] % 2 == 0 && commands[2].equals("even")) {
                numbersList.add(numbers[i]);
            } else if (numbers[i] % 2 != 0 && commands[2].equals("odd")) {
                numbersList.add(numbers[i]);
            }
        }

        return numbersList;
    }
}
