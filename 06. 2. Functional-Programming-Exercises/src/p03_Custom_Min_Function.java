import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class p03_Custom_Min_Function {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Arrays.stream(reader.readLine().split("\\s+ "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> minFunction = minNumber -> Collections.min(Arrays.asList(minNumber));

        System.out.println(minFunction.apply(numbers));
    }
}
