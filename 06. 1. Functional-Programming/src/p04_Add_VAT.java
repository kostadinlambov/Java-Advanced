import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class p04_Add_VAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Double[] numbers = Arrays.stream(reader.readLine().split(", "))
                .map(Double::parseDouble)
                .toArray(Double[]::new);

        Function<Double, Double> priceWithVat = x -> x * 1.2;

        System.out.println("Prices with VAT:");
        for (Double number : numbers) {
            String priceToPrint = String.format("%.2f%n", priceWithVat.apply(number))
                    .replaceAll("\\.",",");
            System.out.printf(priceToPrint);
        }
    }
}
