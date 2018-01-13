import java.util.Scanner;

public class p01_Calculate_Triangle_Area_Method {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double triangleArea = calculateArea(base, height);

        System.out.printf("Area = %.2f", triangleArea);
    }

    private static double calculateArea(double base, double height) {

        double triangleArea = base * height / 2;

        return triangleArea;
    }
}
