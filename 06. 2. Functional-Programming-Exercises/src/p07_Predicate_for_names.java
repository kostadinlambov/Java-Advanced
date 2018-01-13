import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class p07_Predicate_for_names {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int stringsLength = Integer.parseInt(reader.readLine());

        String[] namesArr = reader.readLine().split("\\s+");

        BiPredicate<Integer, String> isLengthMoreOrEqualThan = (length, name) -> name.length() <= length;

        for (String name : namesArr) {
            if(isLengthMoreOrEqualThan.test(stringsLength, name)){
                System.out.println(name);
            }
        }
    }
}
