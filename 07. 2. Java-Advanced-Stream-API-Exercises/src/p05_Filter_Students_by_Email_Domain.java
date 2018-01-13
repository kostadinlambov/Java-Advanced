import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class p05_Filter_Students_by_Email_Domain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();

        while (true) {
            String tokens = reader.readLine();

            if ("END".equalsIgnoreCase(tokens)) {
                break;
            }

            students.add(tokens);
        }
         students.stream()
                .filter(x -> x.split("\\s+")[3].endsWith("@gmail.com"))
                .forEach(x -> {
                    String[] tokens = x.split("\\s+");
                    System.out.println(tokens[1] + " " + tokens[2] + " " + tokens[3]);
                });
    }
}
