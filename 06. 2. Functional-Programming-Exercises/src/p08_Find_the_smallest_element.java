import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class p08_Find_the_smallest_element {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        List<Integer> numbersList = Arrays.asList(numbers);

        Function<List<Integer>, Integer> minElementIndex = numList -> {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < numbersList.size(); i++) {
                if(numbersList.get(i) <= min){
                    min = numbersList.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        };

        System.out.println(minElementIndex.apply(numbersList));
    }
}
