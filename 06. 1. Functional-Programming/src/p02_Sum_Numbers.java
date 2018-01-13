import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class p02_Sum_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(", ");

        Function<String, Integer> parse = x -> Integer.parseInt(x);
        int sum = 0;
        for (String number : numbers) {
          sum += parse.apply(number);
        }

        System.out.println("Count = " + numbers.length);
        System.out.println("Sum = " + sum);
    }
}
