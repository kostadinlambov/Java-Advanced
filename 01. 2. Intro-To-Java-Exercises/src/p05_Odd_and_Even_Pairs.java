import java.util.Arrays;
import java.util.Scanner;

public class p05_Odd_and_Even_Pairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (inputNumbers.length % 2 == 0) {
            for (int i = 0; i < inputNumbers.length; i += 2) {
                if (inputNumbers[i] % 2 == 0 && inputNumbers[i + 1] % 2 == 0) {
                    System.out.printf("%d, %d -> both are even%n", inputNumbers[i], inputNumbers[i + 1]);
                } else if (inputNumbers[i] % 2 == 1 && inputNumbers[i + 1] % 2 == 1) {
                    System.out.printf("%d, %d -> both are odd%n", inputNumbers[i],inputNumbers[i+1]);
                }else{
                    System.out.printf("%d, %d -> different%n", inputNumbers[i],inputNumbers[i+1]);
                }
            }
        }else{
            System.out.println("invalid length");
        }
    }
}
