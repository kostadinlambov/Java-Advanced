import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class p12_The_Party_Reservation_Filter_Module {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] invitations = reader.readLine().split("\\s+");

        List<String> invitationList = new ArrayList<>(Arrays.asList(invitations));
        List<String> filterList = new ArrayList<>();

        while (true) {
            String[] tokens = reader.readLine().split(";");

            if (tokens[0].equalsIgnoreCase("Print")) {
                break;
            }

            String command = tokens[0];
            String filterType = tokens[1];
            String filterParameter = tokens[2];

            Predicate<String> filterPredicate = createFilterPredicate(filterType, filterParameter);

            if (filterPredicate == null) {
                continue;
            }
            switch (command) {
                case "Add filter":
                    addFilter(filterList, invitationList, filterPredicate);
                    break;
                case "Remove filter":
                    filterList.removeIf(filterPredicate);
                    break;
            }
        }

        invitationList.removeAll(filterList);
        System.out.println(invitationList.toString().replaceAll("[,\\]\\[]", ""));
    }

    private static void addFilter(List<String> filterList, List<String> invitationList,
                                  Predicate<String> predicate) {

        List<String> tempList = new ArrayList<>();
        for (String s : invitationList) {
            if (predicate.test(s))
                tempList.add(s);
        }
        filterList.addAll(tempList);
    }

    private static Predicate<String> createFilterPredicate(String filterType, String filterParameter) {
        switch (filterType) {
            case "Starts with":
                return x -> x.startsWith(filterParameter);
            case "Ends with":
                return x -> x.endsWith(filterParameter);
            case "Length":
                return x -> x.length() == Integer.parseInt(filterParameter);
            case "Contains":
                return x -> x.contains(filterParameter);
            default:
                return null;
        }
    }
}
