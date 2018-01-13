import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p06_Filter_Students_by_Phone {
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
                .filter(x -> x.split("\\s+")[10].startsWith("02")
                        || x.split("\\s+")[10].startsWith("+3592"))
                .forEach(x -> {
                    String[] tokens = x.split("\\s+");
                    System.out.println(tokens[1] + " " + tokens[2] + " " + tokens[10]);
                });
    }
}
