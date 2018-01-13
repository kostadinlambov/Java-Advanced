import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class p06_Academy_Graduation {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Double> students = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String name = reader.readLine();

            Double[] scores = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);

            double sum = 0;
            for (int j = 0; j < scores.length; j++) {
                sum += scores[j];
            }

            double averageGrade =  sum / scores.length;
//            double averageGrade = Arrays.stream(scores)
//                    .mapToDouble(a -> a)
//                    .average()
//                    .getAsDouble();

            students.put(name, averageGrade);
        }


        DecimalFormat df = new DecimalFormat("#.##");
        for (Map.Entry<String, Double> student : students.entrySet()) {
            System.out.printf("%s is graduated with %s%n", student.getKey(), student.getValue().toString());
        }
    }
}
