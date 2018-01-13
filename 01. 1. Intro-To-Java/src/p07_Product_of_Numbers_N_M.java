import java.math.BigInteger;
import java.util.Scanner;

public class p07_Product_of_Numbers_N_M {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        BigInteger bigInteger =  BigInteger.ONE;

        int initialX = x;

        do{
            BigInteger i = new BigInteger(String.valueOf(x));
            bigInteger = bigInteger.multiply(i);
            x++;

        }while( x <= y);

        System.out.printf("product[%d..%d] = %d\n", initialX, y, bigInteger);
    }
}
