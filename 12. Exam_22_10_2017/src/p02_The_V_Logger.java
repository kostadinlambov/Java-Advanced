import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p02_The_V_Logger {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> vlogerMap = new LinkedHashMap<>();
        Map<String, Integer> countOfUserFollowingMap = new TreeMap<>();

        String[] tokens = reader.readLine().split("\\s+");

        while (!"Statistics".equalsIgnoreCase(tokens[0])) {
            String command = tokens[1];

            switch (command) {
                case "joined":
                    String vlogerName = tokens[0];
                    vlogerMap.putIfAbsent(vlogerName, new ArrayList<>());
                    countOfUserFollowingMap.putIfAbsent(vlogerName, 0);
                    break;
                case "followed":
                    String firstVloger = tokens[0];
                    String secondVloger = tokens[2];
                    if (vlogerMap.containsKey(firstVloger) && vlogerMap.containsKey(secondVloger)
                            && !firstVloger.equalsIgnoreCase(secondVloger) && !vlogerMap.get(secondVloger).contains(firstVloger)) {
                        vlogerMap.get(secondVloger).add(firstVloger);
                        countOfUserFollowingMap.put(firstVloger, countOfUserFollowingMap.get(firstVloger) + 1);
                    }
                    break;
            }
            tokens = reader.readLine().split("\\s+");
        }

        Map<String, List<String>> sortedMap = vlogerMap.entrySet().stream()
                .sorted((firstLogger, secondLogger) -> {
                    if(Integer.compare(secondLogger.getValue().size(), firstLogger.getValue().size()) == 0){
                        return Integer.compare(countOfUserFollowingMap.get(firstLogger.getKey()),
                                countOfUserFollowingMap.get(secondLogger.getKey()));
                    }
                    return Integer.compare(secondLogger.getValue().size(), firstLogger.getValue().size());
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));


        System.out.printf("The V-Logger has a total of %s vloggers in its logs.%n", vlogerMap.size());
        int vlogersPrintCounter = 1;
        for (Map.Entry<String, List<String>> member : sortedMap.entrySet()) {
            if(vlogersPrintCounter == 1){
                System.out.printf("%d. %s : %d followers, %d following%n",vlogersPrintCounter,
                        member.getKey(), member.getValue().size(), countOfUserFollowingMap.get(member.getKey()));
                member.getValue().sort(Comparator.naturalOrder());
                for (int i = 0; i < member.getValue().size(); i++) {
                    System.out.printf("*  %s%n", member.getValue().get(i));
                }
                vlogersPrintCounter++;
            }else{
                System.out.printf("%d. %s : %d followers, %d following%n",vlogersPrintCounter,
                        member.getKey(), member.getValue().size(), countOfUserFollowingMap.get(member.getKey()));
                vlogersPrintCounter++;
            }
        }
    }
}
