import java.util.Scanner;

public class p01_Read_Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next("\\w+");
        String secondWord = scanner.next("\\w+");

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();

        int sum = firstNum + secondNum + thirdNum;

        scanner.nextLine();
        String thirdWord = scanner.nextLine();

        System.out.printf("%s %s %s %d", firstWord, secondWord, thirdWord, sum);
    }
}
