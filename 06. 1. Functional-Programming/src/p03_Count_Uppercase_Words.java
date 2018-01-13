import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class p03_Count_Uppercase_Words {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        Predicate<String> startsWith = x -> x.charAt(0) == x.toUpperCase().charAt(0);

        List<String> wordsStartWithUpperChar = new ArrayList<>();
        for (String s : input) {
            if(startsWith.test(s)){
                wordsStartWithUpperChar.add(s);
            }
        }

        System.out.println(wordsStartWithUpperChar.size());
        for (String word : wordsStartWithUpperChar) {
            System.out.println(word);
        }
    }
}
