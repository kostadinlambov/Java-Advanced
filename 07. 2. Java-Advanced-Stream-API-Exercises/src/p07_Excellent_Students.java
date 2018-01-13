import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class p07_Excellent_Students {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();
        LinkedHashMap <String, List<Integer>> studentsMap = new LinkedHashMap<>();

        while (true) {
            String[] token = reader.readLine().split("\\s+");
            if (token[0].equalsIgnoreCase("END")) {
                break;
            }

            if(token[6].contains("6")||token[7].contains("6")
                    ||token[8].contains("6")||token[9].contains("6")){

                List<Integer> grades = new ArrayList<>();
                Collections.addAll(grades, Integer.parseInt(token[6]), Integer.parseInt(token[7]),
                        Integer.parseInt(token[8]),Integer.parseInt(token[9]));
                grades.sort(Comparator.reverseOrder());

                String names = token[1] + " "+ token[2];
                studentsMap.putIfAbsent(names, grades);
            }
        }

        studentsMap.entrySet().stream()
                .forEach(st -> {
                    System.out.printf("%s ", st.getKey());
                    st.getValue().stream()
                            .forEach(x -> System.out.printf("%d ", x));
                    System.out.println();
                });
    }
}
