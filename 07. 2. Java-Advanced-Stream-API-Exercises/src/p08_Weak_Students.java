import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p08_Weak_Students {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();
        LinkedHashMap<String, List<Integer>> studentsMap = new LinkedHashMap<>();

        while (true) {
            String[] token = reader.readLine().split("\\s+");
            if (token[0].equalsIgnoreCase("END")) {
                break;
            }

            List<Integer> grades = new ArrayList<>();
            Collections.addAll(grades, Integer.parseInt(token[6]), Integer.parseInt(token[7]),
                    Integer.parseInt(token[8]), Integer.parseInt(token[9]));

            int gradesCount = 0;
            for (Integer grade : grades) {
                if (grade <= 3){
                    gradesCount++;
                }
            }

            if (gradesCount > 1) {
                Collections.sort(grades);
                String names = token[1] + " " + token[2];
                studentsMap.putIfAbsent(names, grades);
            }
        }

        studentsMap.entrySet().stream()
                .sorted(Comparator.comparingInt(a -> a.getValue().stream().mapToInt(Integer::valueOf).sum()))
                .forEach(st -> {
                    System.out.printf("%s ", st.getKey());
                    st.getValue().stream()
                            .forEach(x -> System.out.printf("%d ", x));
                    System.out.println();
                });
    }
}
