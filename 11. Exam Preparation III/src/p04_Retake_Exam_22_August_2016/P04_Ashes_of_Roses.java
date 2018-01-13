package p04_Retake_Exam_22_August_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toMap;

public class P04_Ashes_of_Roses {

    private String regionName;
    private Map<String, Long> rosesMap;

    public P04_Ashes_of_Roses(String regionName) {
        this.regionName = regionName;
        this.rosesMap = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {

        Map<String, P04_Ashes_of_Roses> regionsMap = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String inputLine = reader.readLine();
            if ("Icarus, Ignite!".equalsIgnoreCase(inputLine)) {
                break;
            }

            Pattern regex = Pattern.compile("^Grow <([A-Z][a-z]+)> <([A-Za-z0-9]+)> (\\d+)$");
            Matcher matcher = regex.matcher(inputLine);

            if (matcher.find()) {
                String regionName = matcher.group(1);
                String colorName = matcher.group(2);
                Long roseAmount = Long.parseLong(matcher.group(3));

                //System.out.println();

                if (!regionsMap.containsKey(regionName)) {
                    P04_Ashes_of_Roses region = new P04_Ashes_of_Roses(regionName);
                    regionsMap.put(regionName, region);
                }

                if (!regionsMap.get(regionName).rosesMap.containsKey(colorName)) {
                    regionsMap.get(regionName).rosesMap.put(colorName, 0L);
                }
                regionsMap.get(regionName)
                        .rosesMap.put(colorName, regionsMap.get(regionName).rosesMap.get(colorName) + roseAmount);
            }

        }

        LinkedHashMap<String, P04_Ashes_of_Roses> sortedRegionsMap = regionsMap.entrySet().stream().
                sorted((x, y) -> {
                    if (Long.compare(y.getValue().rosesMap.values().stream().mapToLong(Long::valueOf).sum(),
                            x.getValue().rosesMap.values().stream().mapToLong(Long::valueOf).sum()) == 0) {
                        return x.getKey().compareTo(y.getKey());
                    }
                    return Long.compare(y.getValue().rosesMap.values().stream().mapToLong(Long::valueOf).sum(),
                            x.getValue().rosesMap.values().stream().mapToLong(Long::valueOf).sum());
                })
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        sortedRegionsMap.entrySet().stream().forEach(region -> {
            System.out.println(region.getKey());
            region.getValue().rosesMap.entrySet().stream()
                    .sorted((x, y) -> {
                        if (Long.compare(x.getValue(), y.getValue()) == 0) {
                            return x.getKey().compareTo(y.getKey());
                        }
                        return Long.compare(x.getValue(), y.getValue());
                    })
                    .forEach(colorName -> {
                        System.out.printf("*--%s | %d%n", colorName.getKey(), colorName.getValue());
                    });
        });
    }
}