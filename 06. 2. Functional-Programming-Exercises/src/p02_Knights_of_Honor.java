import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.function.Consumer;

public class p02_Knights_of_Honor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine = reader.readLine().split("\\s+");

        Consumer<String> print = name -> System.out.printf("Sir %s%n",name);

        for (String name : inputLine) {
            print.accept(name);
        }
    }
}
