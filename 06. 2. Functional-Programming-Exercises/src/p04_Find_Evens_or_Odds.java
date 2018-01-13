import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class p04_Find_Evens_or_Odds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] boundaries = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = reader.readLine();

        Predicate<Integer> isEven = number -> number % 2 == 0;

        for (int i = boundaries[0]; i <= boundaries[1]; i++) {
            if (command.equalsIgnoreCase("even") && isEven.test(i)) {
                System.out.print(i + " ");
            } else if (command.equalsIgnoreCase("odd") && !isEven.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
