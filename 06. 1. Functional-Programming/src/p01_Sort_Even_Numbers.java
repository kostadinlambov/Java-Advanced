import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p01_Sort_Even_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        List<Integer> numbersList = new ArrayList<>();
        numbersList.addAll(Arrays.asList(numbers));
        numbersList.removeIf(n -> n % 2 != 0);

        System.out.println(numbersList
                .toString()
                .replaceAll("[\\[\\]]",""));

        numbersList.sort((a, b) -> a.compareTo(b));

        System.out.println(numbersList
                .toString()
                .replaceAll("[\\[\\]]",""));
    }
}
