import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p13_Hands_of_Cards {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();

        while (true) {

            String[] inputLine = reader.readLine().split(":");
            if (inputLine[0].equalsIgnoreCase("JOKER")) {
                break;
            }
            String name = inputLine[0];
            String[] cards = inputLine[1].trim().split(", ");

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }

            players.get(name).addAll(Arrays.asList(cards));
        }

        if(players.size() > 0){
            calculateValues(players);
        }

    }

    private static void calculateValues(HashMap<String, HashSet<String>> players) {

        LinkedHashMap<String, Integer> results = new LinkedHashMap<>();

        for (Map.Entry<String, HashSet<String>> player : players.entrySet()) {

            List<String> cards = new ArrayList<>(player.getValue());
            int totalValuePlayer = 0;

            for (String card : cards) {
                String power = card.substring(0, card.length() - 1);
                String type = card.substring(card.length() - 1);

                int value = calculatePlayersTotalValue(power, type);
                totalValuePlayer += value;
            }

            results.put(player.getKey(), totalValuePlayer);
        }

        for (Map.Entry<String, Integer> result : results.entrySet()) {
            System.out.printf("%s: %d%n", result.getKey(), result.getValue());
        }
    }

    private static int calculatePlayersTotalValue(String power, String type) {

        int typeInt = 1;
        int powerInt = 1;

        switch (type) {
            case "S":
                typeInt = 4;
                break;
            case "H":
                typeInt = 3;
                break;
            case "D":
                typeInt = 2;
                break;
            case "C":
                typeInt = 1;
                break;
        }

        switch (power) {
            case "2":
                powerInt = 2;
                break;
            case "3":
                powerInt = 3;
                break;
            case "4":
                powerInt = 4;
                break;
            case "5":
                powerInt = 5;
                break;
            case "6":
                powerInt = 6;
                break;
            case "7":
                powerInt = 7;
                break;
            case "8":
                powerInt = 8;
                break;
            case "9":
                powerInt = 9;
                break;
            case "10":
                powerInt = 10;
                break;
            case "J":
                powerInt = 11;
                break;
            case "Q":
                powerInt = 12;
                break;
            case "K":
                powerInt = 13;
                break;
            case "A":
                powerInt = 14;
                break;
        }

        return typeInt * powerInt;
    }
}
