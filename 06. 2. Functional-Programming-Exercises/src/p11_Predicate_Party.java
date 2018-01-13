import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class p11_Predicate_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] people = reader.readLine().split("\\s+");
        List<String> peopLeList = new ArrayList<String>(Arrays.asList(people));

        while (true) {

            String[] tokens = reader.readLine().split("\\s+");

            if (tokens[0].equalsIgnoreCase("Party!")) {
                break;
            }

            String command = tokens[0];
            String firstCondition = tokens[1];
            String secondCondition = tokens[2];

            Predicate<String> conditionPredicate = createConditionPredicate(firstCondition, secondCondition);

            if (conditionPredicate == null) {
                continue;
            }

            switch (command) {
                case "Remove":
                    peopLeList.removeIf(conditionPredicate);
                    break;
                case "Double":
                    for (int i = 0; i < peopLeList.size(); i++) {
                        if (conditionPredicate.test(peopLeList.get(i))) {
                            peopLeList.add(i, peopLeList.get(i));
                            i++;
                        }
                    }
                    break;
            }
        }

        if (peopLeList.size() > 0) {
            System.out.print(peopLeList
                    .toString()
                    .replaceAll("[\\]\\[]", ""));
            System.out.println(" are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static Predicate<String> createConditionPredicate(String firstCondition, String secondCondition) {
        switch (firstCondition) {
            case "StartsWith":
                return x -> x.startsWith(secondCondition);
            case "EndsWith":
                return x -> x.endsWith(secondCondition);
            case "Length":
                return x -> x.length() == Integer.parseInt(secondCondition);
            default:
                return null;
        }
    }
}
