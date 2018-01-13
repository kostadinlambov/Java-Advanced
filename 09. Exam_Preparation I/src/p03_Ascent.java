import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern regex = Pattern.compile("(?<character>[,_])(?<message>[A-Za-z]+)(?<digit>[0-9])");

        Map<String, String> matchesMap = new LinkedHashMap<>();

        while (true) {
            String inputLine = reader.readLine();
            inputLine = replaceMessage(inputLine, matchesMap);

            if ("Ascend".equalsIgnoreCase(inputLine)) {
                break;
            }
            Matcher matcher = regex.matcher(inputLine);
            while (matcher.find()) {
                String fullMatch = matcher.group();
                String character = matcher.group("character");
                String message = matcher.group("message");
                int digit = Integer.parseInt(matcher.group("digit"));

                StringBuilder encodedMessage = new StringBuilder();
                if (character.equals(",")) {
                    for (int i = 0; i < message.length(); i++) {
                        encodedMessage.append((char) (message.charAt(i) + digit));
                    }
                } else if (character.equals("_")) {
                    for (int i = 0; i < message.length(); i++) {
                        encodedMessage.append((char) (message.charAt(i) - digit));
                    }
                }
                matchesMap.put(fullMatch, encodedMessage.toString());
                inputLine = inputLine.replace(fullMatch, encodedMessage.toString());
            }
            System.out.println(inputLine);
        }
    }

    private static String replaceMessage(String inputLine, Map<String, String> matchesMap) {
        for (Map.Entry<String, String> match : matchesMap.entrySet()) {
            inputLine = inputLine.replaceAll(match.getKey(), match.getValue());
        }
        return inputLine;
    }
}

