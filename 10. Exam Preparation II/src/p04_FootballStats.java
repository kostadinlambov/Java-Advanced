import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_FootballStats {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, TreeMap<String, List<String>>> statsMap = new HashMap<>();

        while (true) {
            String inputLine = reader.readLine();
            if ("Season End".equalsIgnoreCase(inputLine)) {
                break;
            }

            Pattern regex = Pattern.compile("(?<firstTeam>\\w+) - (?<secondTeam>\\w+)(\\s+\\w+?\\s+)" +
                    "(?<firstTeamGoals>\\d+):(?<secondTeamGoals>\\d+)");
            Matcher matcher = regex.matcher(inputLine);

            if (matcher.find()) {
                String firstTeam = matcher.group("firstTeam");
                String secondTeam = matcher.group("secondTeam");
                String firstTeamGoals = matcher.group("firstTeamGoals");
                String secondTeamGoals = matcher.group("secondTeamGoals");

                String resultHomeTeam = firstTeamGoals + ":" + secondTeamGoals;
                String resultAwayTeam = secondTeamGoals + ":" + firstTeamGoals;

                if (!statsMap.containsKey(firstTeam)) {
                    statsMap.put(firstTeam, new TreeMap<>());
                }
                if (!statsMap.get(firstTeam).containsKey(secondTeam)) {
                    statsMap.get(firstTeam).put(secondTeam, new ArrayList<>());
                }

                statsMap.get(firstTeam).get(secondTeam).add(resultHomeTeam);

                if (!statsMap.containsKey(secondTeam)) {
                    statsMap.put(secondTeam, new TreeMap<>());
                }

                if (!statsMap.get(secondTeam).containsKey(firstTeam)) {
                    statsMap.get(secondTeam).put(firstTeam, new ArrayList<>());
                }

                statsMap.get(secondTeam).get(firstTeam).add(resultAwayTeam);
            }
        }

        String[] teamsToPrint = reader.readLine().split(", ");

        for (int i = 0; i < teamsToPrint.length; i++) {

            String teamToPrint = teamsToPrint[i];

            statsMap.entrySet().stream()
                    .filter(x -> x.getKey().equalsIgnoreCase(teamToPrint))
                    .forEach(firstTeam -> {
                        firstTeam.getValue().entrySet()
                                .stream()
                                .forEach(secondTeam ->
                                        secondTeam.getValue()
                                                .forEach(score -> System.out.println(firstTeam.getKey() + " - "
                                                        + secondTeam.getKey() + " -> " + score)));
                    });
        }
    }
}