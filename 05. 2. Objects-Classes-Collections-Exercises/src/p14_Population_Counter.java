import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class p14_Population_Counter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedHashMap<String, Long>> populationMap = new LinkedHashMap<>();

        while (true) {
            String[] tokens = reader.readLine().split("\\|");

            if (tokens[0].equalsIgnoreCase("report")) {
                break;
            }
            String city = tokens[0];
            String country = tokens[1];
            Long population = Long.parseLong(tokens[2]);

            if (!populationMap.containsKey(country)) {
                populationMap.put(country, new LinkedHashMap<>());
            }

            if (!populationMap.get(country).containsKey(city)) {
                populationMap.get(country).put(city, 0L);
            }
            populationMap.get(country).put(city, populationMap.get(country).get(city) + population);
        }

        LinkedHashMap<String, Long> result = new LinkedHashMap<>();

        for (String s : populationMap.keySet()) {

            LinkedHashMap<String, Long> sorted = populationMap.get(s).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new));

            Long totalPopulation = 0L;
            String towns = "";
            for (String s1 : sorted.keySet()) {
                Long townPopulation = populationMap.get(s).get(s1);
                totalPopulation += townPopulation;
                towns += "=>" + s1 + ": " + townPopulation + "\n";
            }

            towns = s + " (total population: " + totalPopulation + ")" + "\n" + towns.substring(0, towns.length() - 1);
            result.put(towns, totalPopulation);
        }

        LinkedHashMap<String, Long> sorted = result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        for (String s : sorted.keySet()) {
            System.out.println(s);
        }
    }
}
