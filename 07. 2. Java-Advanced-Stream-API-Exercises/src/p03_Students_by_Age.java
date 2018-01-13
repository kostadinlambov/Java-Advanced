import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p03_Students_by_Age {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> studentsList = new ArrayList<>();

        while (true) {

            String[] tokens = reader.readLine().split("\\s+");
            if (tokens[0].equalsIgnoreCase("END")){
                break;
            }

                String names = tokens[1] + " " + tokens[2];
            int age = Integer.parseInt(tokens[4]);

            if (age >= 18 && age <= 24) {
                studentsList.add(names + " " + age);
            }
        }

        for (String s : studentsList) {
            System.out.println(s);
        }
    }
}
