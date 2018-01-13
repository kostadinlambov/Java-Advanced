import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p14_Population_Counter_Third_Version {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap();

        while(true) {
            String[] line = reader.readLine().split("\\|");

            if("report".equalsIgnoreCase(line[0])){
                break;
            }


            if(!countries.containsKey(line[1])){
                countries.putIfAbsent(line[1], new LinkedHashMap<>());
                countries.get(line[1]).put(line[0], Long.parseLong(line[2]));
            }
            countries.get(line[1]).put(line[0],  Long.valueOf(line[2]));


            Map<String, Long> countriesPopulations = new LinkedHashMap<>();

            for (String country : countries.keySet()) {

                LinkedHashMap<String, Long> sortedTowns = countries.get(country).entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (a,b) -> a , LinkedHashMap::new));


                StringBuilder result = new StringBuilder();
                Long sum = 0L;
                for (String s : sortedTowns.keySet()) {
                    sum += sortedTowns.get(s);
                }

                countriesPopulations.put(country, sum);
            }

            countriesPopulations.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    .forEach((b) -> {
                        System.out.println(b.getKey() + " (total population: " + b.getValue() + ")");
                        countries.get(b.getKey()).entrySet().stream()
                                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                                .forEach(a -> System.out.println("=> " + a.getKey() + ":" + a.getValue()) );




                    });
        }
    }
}
