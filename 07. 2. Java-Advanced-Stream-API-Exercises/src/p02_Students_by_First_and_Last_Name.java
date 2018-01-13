import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class p02_Students_by_First_and_Last_Name {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, String> names = new LinkedHashMap<>();
        LinkedList<String> namesList = new LinkedList<>();

        while (true) {

            String[] tokens = reader.readLine().split("\\s+");
            if(tokens[0].equalsIgnoreCase("END")){
                break;
            }

            String firstName = tokens[0];
            String lastName = tokens[1];

            if(compareNames(firstName, lastName)){
                namesList.add(firstName + " " + lastName);
            }
        }

        namesList
                .forEach(x -> System.out.println(x));

    }

    private static boolean compareNames(String key, String value) {
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) < value.charAt(i)) {
                return true;
            } else if (key.charAt(i) > value.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}