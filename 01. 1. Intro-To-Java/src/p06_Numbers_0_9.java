import java.util.Scanner;

public class p06_Numbers_0_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;

        while(counter < 10){
            System.out.printf("Number: %s%n", counter);
            counter++;
        }
    }
}
