import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p09_Students_Enrolled_in_2014_or_2015 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();
        TreeMap<String, List<String>> studentsMap = new TreeMap<>();

        while (true) {
            String[] token = reader.readLine().split("\\s+");

            if (token[0].equalsIgnoreCase("END")) {
                break;
            }

            String names = token[1] + " " + token[2];
            String mapKey = token[0].substring(token[0].length() - 2);

            if(!studentsMap.containsKey(mapKey)){
                studentsMap.put(mapKey, new ArrayList<>());
            }

            studentsMap.get(mapKey).add(names);
        }

        studentsMap.entrySet().stream()
                .forEach( e ->{
                    System.out.printf("20%s:%n", e.getKey());
                    e.getValue().stream()
                            .sorted()
                            .forEach(n -> System.out.printf("-- %s%n", n));
                });
    }
}

