import java.util.Scanner;

public class p08_Lottery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int firstNum = 1; firstNum <= 8 ; firstNum++) {
            for (int secondNum = firstNum+1; secondNum <=9 ; secondNum++) {
                for (int thirdNum = secondNum + 1; thirdNum <= 10; thirdNum++) {

                    System.out.printf("%d %d %d%n", firstNum, secondNum, thirdNum);
                }
            }
        }
    }
}
