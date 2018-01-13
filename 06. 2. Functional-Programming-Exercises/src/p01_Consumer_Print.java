import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class p01_Consumer_Print {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        Consumer<String> print = name -> System.out.println(name);

        for(String name : input){
            print.accept(name);
        }
    }
}
