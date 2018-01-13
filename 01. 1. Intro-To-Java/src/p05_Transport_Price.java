import java.util.Scanner;

public class p05_Transport_Price {
    private static final float initialTax = 0.7f;
    private static final float dayTimeTax = 0.79f;
    private static final float nightTimeTax = 0.9f;
    private static final float busTax = 0.09f;
    private static final float trainTax = 0.06f;
    private static final int forBusKilometers = 20;
    private static final int forTrainKilometers = 100;
    private static final String dayShift = "day";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kilometers = Integer.parseInt(scanner.nextLine());
        String shift = scanner.nextLine();

        float tax = 0f;

        if (kilometers < forBusKilometers) {
            if (shift.equals("day")) {
                tax = dayTimeTax;
            } else {
                tax = nightTimeTax;
            }
            float mainTax = kilometers * tax;
            float total = mainTax + initialTax;
            System.out.printf("%.2f", total);
        } else if (kilometers < forTrainKilometers) {
            tax = busTax;
            System.out.printf("%.2f", kilometers * tax);
        } else {
            tax = trainTax;
            System.out.printf("%.2f", kilometers * tax);
        }
    }
}
