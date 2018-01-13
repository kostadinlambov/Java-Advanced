package p05_Java_Advanced_Exam_19_June_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class P04_Cubic_Assault {
    private String region;
    private Map<String, Long> typeMap;

    public P04_Cubic_Assault(String region) {
        this.region = region;
        this.setTypeMap();
    }

    private void setTypeMap() {
        this.typeMap = new LinkedHashMap<>();
        this.typeMap.put("Black", 0L);
        this.typeMap.put("Red", 0L);
        this.typeMap.put("Green", 0L);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, P04_Cubic_Assault> regionsMap = new LinkedHashMap<>();

        while (true) {
            String inputLine = reader.readLine();
            if ("Count em all".equalsIgnoreCase(inputLine)) {
                break;
            }

            String[] tokens = inputLine.split(" -> ");
            String region = tokens[0];

            String type = tokens[1];
            long amountOfSoldiers = Long.parseLong(tokens[2]);

            if (!regionsMap.containsKey(region)) {
                P04_Cubic_Assault regionInstance = new P04_Cubic_Assault(region);
                regionsMap.put(region, regionInstance);
            }

            regionsMap.get(region).typeMap.put(type, regionsMap.get(region).typeMap.get(type) + amountOfSoldiers);


            if (regionsMap.get(region).typeMap.get("Green") > 999_999) {
                regionsMap.get(region).typeMap.put("Red", regionsMap.get(region).typeMap.get("Red") +
                        regionsMap.get(region).typeMap.get("Green") / 1_000_000);
                regionsMap.get(region).typeMap.put("Green", regionsMap.get(region).typeMap.get("Green") % 1_000_000);
            }

            if (regionsMap.get(region).typeMap.get("Red") > 999_999) {
                regionsMap.get(region).typeMap.put("Black", regionsMap.get(region).typeMap.get("Black") +
                        regionsMap.get(region).typeMap.get("Red") / 1_000_000);
                regionsMap.get(region).typeMap.put("Red", regionsMap.get(region).typeMap.get("Red") % 1_000_000);
            }
        }

        Map<String, P04_Cubic_Assault> sortedMap = regionsMap.entrySet().stream()
                .sorted((x, y) -> {
                    if (Long.compare(y.getValue().typeMap.get("Black"), x.getValue().typeMap.get("Black")) == 0) {
                        if (Integer.compare(x.getKey().length(), y.getKey().length()) == 0) {
                            return x.getKey().compareTo(y.getKey());
                        }
                        return Integer.compare(x.getKey().length(), y.getKey().length());
                    }
                    return Long.compare(y.getValue().typeMap.get("Black"), x.getValue().typeMap.get("Black"));
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));


        sortedMap.entrySet().stream().forEach(region -> {
            System.out.println(region.getKey());
            region.getValue().typeMap.entrySet().stream()
                    .sorted((x, y) -> {
                        if (Long.compare(y.getValue(), x.getValue()) == 0) {
                            return x.getKey().compareTo(y.getKey());
                        }
                        return Long.compare(y.getValue(), x.getValue());
                    })
                    .forEach(type ->{
                        System.out.printf("-> %s : %d%n", type.getKey(), type.getValue());
                    });
        });
    }
}
