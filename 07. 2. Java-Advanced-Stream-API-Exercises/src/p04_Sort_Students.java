import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class p04_Sort_Students {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> names = new HashSet<>();

        while (true) {

            String[] token = reader.readLine().split("\\s+");

            if (token[0].equalsIgnoreCase("END")) {
                break;
            }

            names.add(token[1] + " " + token[2]);
        }

        names.stream()
                .sorted((a, b) -> {
                    if (a.split("\\s+")[1].compareTo(b.split("\\s+")[1]) == 0) {
                        return b.split("\\s+")[0].compareTo(a.split("\\s+")[0]);
                    }
                    return a.split("\\s+")[1].compareTo(b.split("\\s+")[1]);
                })
                .forEach(x -> System.out.println(x));
    }
}
