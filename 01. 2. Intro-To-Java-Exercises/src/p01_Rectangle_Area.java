import java.util.Scanner;

public class p01_Rectangle_Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstSide = scanner.nextDouble();
        double secondSide = scanner.nextDouble();

        double area = firstSide * secondSide;
        System.out.printf("%.2f", area);
    }
}
