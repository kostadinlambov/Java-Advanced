import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p02_Upper_Strings {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(reader.readLine().split("\\s+"))
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.print(s + " "));
    }
}
