import java.math.BigInteger;
import java.util.Scanner;

public class p08_Multiply_Big_Number_Two {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num1 = scan.nextLine();
        String num2 = scan.nextLine();

        System.out.println(new BigInteger(num1).multiply(new BigInteger(num2)));
    }
}
