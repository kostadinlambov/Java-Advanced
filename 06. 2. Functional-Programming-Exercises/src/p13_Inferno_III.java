import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class p13_Inferno_III {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        HashMap<String, Predicate<Integer>> commands = new HashMap<>();

        while (true) {
            String[] input = reader.readLine().split(";");

            if ("Forge".equals(input[0])) {
                break;
            }

            Predicate<Integer> predicate = makePradicate(input, arr);

            if ("Exclude".equalsIgnoreCase(input[0])) {
                commands.put((input[1] + input[2]), predicate);
            } else {
                commands.remove( input[1] + input[2]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            boolean forRemove = false;
            for (Map.Entry<String, Predicate<Integer>> stringPredicateEntry : commands.entrySet()) {
                if (stringPredicateEntry.getValue().test(i)) {
                    forRemove = true;
                    break;
                }
            }
            if (!forRemove) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static Predicate<Integer> makePradicate(String[] input, int[] arr) {
        switch (input[1].toUpperCase()) {
            case "SUM LEFT":
                return index -> (index > 0 ? arr[index - 1] : 0) + arr[index] == Integer.valueOf(input[2]);
            case "SUM RIGHT":
                return index -> arr[index] + (index < arr.length - 1 ? arr[index + 1] : 0) == Integer.valueOf(input[2]);
            default:
                return index -> (index > 0 ? arr[index - 1] : 0) + arr[index] +
                        (index < arr.length - 1 ? arr[index + 1] : 0) == Integer.valueOf(input[2]);
        }
    }
}
