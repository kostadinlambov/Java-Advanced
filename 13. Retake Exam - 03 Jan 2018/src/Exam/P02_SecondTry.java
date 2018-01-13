package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_SecondTry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        List<String> crates = new LinkedList<>();
        List<String> validCrates = new LinkedList<>();
        int drinks = 0;
        int food = 0;

        Pattern pattern = Pattern.compile("\\[.*?\\]");
        int cratesCount = 0;

        while (!"Collect".equalsIgnoreCase(input)) {

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                cratesCount++;
            }

            crates.add(input);
            input = br.readLine();
        }
        int islandParts = crates.size();

        int N = cratesCount / islandParts;

        Pattern cratePattern = Pattern.compile("\\[(?<tag>#[\\d|\\w]{" + N + "})(?<supply>[a-zA-Z0-9\\s*]+)(?<tag2>#[\\d|\\w]{" + N + "})\\]");

        for (int i = 0; i < crates.size(); i++) {

            String line = crates.get(i);

            Matcher matcher = cratePattern.matcher(line);

            while (matcher.find()) {
                String tag = matcher.group("tag");
                String tag2 = matcher.group("tag2");

                if (!tag.equals(tag2)) {
                    continue;
                }

                String body = matcher.group("supply");

                if (Character.isAlphabetic(tag.charAt(1))) {
                    if (tag.equals(tag.toLowerCase())) {
                        validCrates.add(line);
                        drinks += getDrinks(tag, body);
                    }
                } else if (Character.isDigit(tag.charAt(1))) {
                    validCrates.add(line);
                    food += getFood(N, body);
                }
            }
        }
        if (validCrates.size() == 0) {
            System.out.println("No supplies found!");
            return;
        }

        System.out.printf("Number of supply crates: %d\n", validCrates.size());
        System.out.printf("Amount of food collected: %d\n", food);
        System.out.printf("Amount of drinks collected: %d\n", drinks);


    }

    private static int getDrinks(String tag, String body) {

        String tagLetters = tag.substring(1, tag.length());
        int sum = 0;

        for (int i = 0; i < tagLetters.length(); i++) {
            sum += tagLetters.charAt(i);
        }

        int sumUnique = 0;

        for (int i = 0; i < body.length(); i++) {
            sumUnique += body.charAt(i);
        }

        return sum * sumUnique;
    }


    private static int getFood(int N, String body) {

        List<Character> uniqElements = new LinkedList<>();

        for (int i = 0; i < body.length(); i++) {
            if (!uniqElements.contains(body.charAt(i))) {
                uniqElements.add(body.charAt(i));
            }

        }

        int sum = 0;


        for (int i = 0; i < uniqElements.size(); i++) {
            sum += uniqElements.get(i);
        }

        return sum * N;
    }
}
