import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toMap;

public class p04_Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Long> totalScoreMap = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> statsMap = new LinkedHashMap<>();

        Pattern regex = Pattern.compile("^(?<scoreFirstPlayer>\\d+)\\s+(?<nameFirstPlayer>[a-zA-Z0-9]+)<->(?<nameSecondPlayer>[a-zA-Z0-9]+)\\s+(?<scoreSecondPlayer>\\d+)$");

        while (true) {

            String inputLine = reader.readLine();
            if ("osu!".equalsIgnoreCase(inputLine)) {
                break;
            }

            Matcher matcher = regex.matcher(inputLine);

            if (matcher.find()) {

                String nameFirstPlayer = matcher.group("nameFirstPlayer");
                long scoreFirstPlayer = Long.parseLong(matcher.group("scoreFirstPlayer"));
                String nameSecondPlayer = matcher.group("nameSecondPlayer");
                long scoreSecondPlayer = Long.parseLong(matcher.group("scoreSecondPlayer"));


                long diffFirstPlayer = scoreFirstPlayer - scoreSecondPlayer;
                long diffSecondPlayer = scoreSecondPlayer - scoreFirstPlayer;

                if (!statsMap.containsKey(nameFirstPlayer)) {
                    statsMap.put(nameFirstPlayer, new ArrayList<>());
                    totalScoreMap.put(nameFirstPlayer, 0L);
                }

                statsMap.get(nameFirstPlayer).add(nameSecondPlayer + " <-> " + diffFirstPlayer);
                totalScoreMap.put(nameFirstPlayer, totalScoreMap.get(nameFirstPlayer) + diffFirstPlayer);

                if (!statsMap.containsKey(nameSecondPlayer)) {
                    statsMap.put(nameSecondPlayer, new ArrayList<>());
                    totalScoreMap.put(nameSecondPlayer, 0L);
                }

                statsMap.get(nameSecondPlayer).add(nameFirstPlayer + " <-> " + diffSecondPlayer);
                totalScoreMap.put(nameSecondPlayer, totalScoreMap.get(nameSecondPlayer) + diffSecondPlayer);
            }
        }

        Map<String, Long> sortedMap = totalScoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        sortedMap.entrySet().stream()
                .forEach(totalScore -> {
                    System.out.printf("%s - (%d)%n", totalScore.getKey(), totalScore.getValue());
                    statsMap.get(totalScore.getKey())
                            .forEach(player -> System.out.printf("*   %s%n", player));
                });
    }
}
