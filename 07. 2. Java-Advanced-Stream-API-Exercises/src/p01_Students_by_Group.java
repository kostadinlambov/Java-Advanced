import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p01_Students_by_Group {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, String> studentsMap = new TreeMap<>();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            if("END".equalsIgnoreCase(tokens[0])){
                break;
            }
            String names = tokens[1] +" " + tokens[2];
            String number = tokens[5];
            studentsMap.putIfAbsent(names, number);
        }

        studentsMap.entrySet().stream()
                .filter(c -> c.getValue().equalsIgnoreCase("2"))
                .forEach(st -> System.out.println(st.getKey()));
    }
}
