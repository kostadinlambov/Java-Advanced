package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P03_The_DHARMA_Initiative {
    private static final Map<String, String> stationsNamesAndPurpose;
    static {
        Map<String, String> aMap = new LinkedHashMap<>();
        aMap.put("Hydra", "Zoological Research.");
        aMap.put("Arrow", "Development of defensive strategies, and Intelligence gathering.");
        aMap.put("Flame", "Communication.");
        aMap.put("Pearl", "Psychological Research and/or Observation.");
        aMap.put("Orchid", "Space-time manipulation research, disguised as a Botanical station.");
        stationsNamesAndPurpose = Collections.unmodifiableMap(aMap);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Recruits>> stationsMap = new TreeMap<>();
        stationsMap.put("Hydra", new ArrayList<>());
        stationsMap.put("Arrow", new ArrayList<>());
        stationsMap.put("Flame", new ArrayList<>());
        stationsMap.put("Pearl", new ArrayList<>());
        stationsMap.put("Orchid", new ArrayList<>());

        while (true) {
            String inputLine = reader.readLine();

            if ("Recruit".equalsIgnoreCase(inputLine)) {
                break;
            }
            String[] tokens = inputLine.split(":");

            String name = tokens[0];
            String facilityNumber = tokens[1];
            String stationName = tokens[2];

            if (stationsNamesAndPurpose.containsKey(stationName)) {

                Recruits recruit = new Recruits(name, facilityNumber, stationName);
                stationsMap.get(stationName).add(recruit);
            }
        }

        if (stationsMap.size() > 0) {
            String command = reader.readLine();

            if ("DHARMA Initiative".equalsIgnoreCase(command)) {

                stationsMap.entrySet().stream()
                        .sorted((x, y) -> {
                            return Integer.compare(y.getValue().size(), x.getValue().size());

                        })
                        .forEach(station -> {
                            System.out.printf("The %s has %d DHARMA recruits in it.%n",
                                    station.getKey(), station.getValue().size());
                        });

            } else if ("Hydra".equalsIgnoreCase(command) || "Arrow".equalsIgnoreCase(command)
                    || "Flame".equalsIgnoreCase(command) || "Pearl".equalsIgnoreCase(command)
                    || "Orchid ".equalsIgnoreCase(command)) {

                if (stationsNamesAndPurpose.containsKey(command)) {
                    stationsMap.entrySet().stream()
                            .filter(x -> x.getKey().equals(command))
                            .forEach(station -> {
                                System.out.printf("The %s station: %s%n",
                                        station.getKey(), stationsNamesAndPurpose.get(station.getKey()));
                                if (station.getValue().size() == 0) {
                                    System.out.println("No recruits.");
                                }else{
                                    station.getValue().stream()
                                            .sorted((o1, o2) -> o2.getFacilityNumber().compareTo(o1.getFacilityNumber()))
                                            .forEach(recruit -> {
                                                System.out.printf("###%s - %s%n", recruit.getName(),
                                                        recruit.getFacilityNumber());
                                            });
                                }
                            });
                }
            } else {
                System.out.println("DHARMA Initiative does not have such a station!");
            }
        }
    }
}

class Recruits {
    private String name;
    private String facilityNumber;
    private String stationName;

    Recruits(String name, String facilityNumber, String stationName) {
        this.name = name;
        this.facilityNumber = facilityNumber;
        this.stationName = stationName;
    }

    String getName() {
        return this.name;
    }

    String getFacilityNumber() {
        return this.facilityNumber;
    }
}

