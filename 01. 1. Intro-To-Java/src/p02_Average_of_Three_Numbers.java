import java.util.Scanner;

public class p02_Average_of_Three_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();

        double average = (firstNum + secondNum + thirdNum) / 3;

        System.out.printf("%.2f", average);
    }
}
