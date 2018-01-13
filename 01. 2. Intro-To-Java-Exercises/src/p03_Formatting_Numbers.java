import java.util.Scanner;

public class p03_Formatting_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        double secondNumber = scanner.nextDouble();
        double thirdNumber = scanner.nextDouble();

        String firstNumToHex = Integer.toHexString(firstNumber).toUpperCase();
        String firstNumToBinary = Integer.toBinaryString(firstNumber);

        System.out.printf("|%-10s|%010d|%10.2f|%-10.3f|", firstNumToHex,
                Integer.parseInt(firstNumToBinary), secondNumber, thirdNumber);
    }
}
