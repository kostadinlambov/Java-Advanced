import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class p09_Custom_Comparator {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> numbers = new ArrayList<>();

        Arrays.stream(new BufferedReader(new InputStreamReader(System.in))
                .readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(numbers::add);

        Comparator<Integer> myComp = (num1, num2) -> {
            if ((num1 % 2 == 0) == (num2 % 2 == 0)) {
                return num1.compareTo(num2);
            } else if (num1 % 2 == 0) {
                return -1;
            } else {
                return 1;
            }
        };

        numbers.sort(myComp);

        System.out.println(numbers
                .toString()
                .replaceAll("[,\\]\\[]", ""));
    }
}
