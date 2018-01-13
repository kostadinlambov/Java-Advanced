import java.math.BigDecimal;
        import java.util.Scanner;

public class p03_Euro_Trip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantity = Double.parseDouble(scanner.nextLine());
        double pricePerKilo = 1.20;
        BigDecimal priceInLewa = new BigDecimal(pricePerKilo*quantity);

        BigDecimal exchangeRate = new BigDecimal("4210500000000");

        BigDecimal totalPriceMarks = exchangeRate.multiply(priceInLewa);
        System.out.printf("%.2f marks", totalPriceMarks);
    }
}
