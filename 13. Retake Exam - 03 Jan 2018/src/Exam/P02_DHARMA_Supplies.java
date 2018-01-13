package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_DHARMA_Supplies {

    static long AmountOfFood = 0L;
    static long AmountOfDrinks = 0L;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // StringBuilder sb = new StringBuilder();

        Pattern regexFood = Pattern.compile("\\[(?<validTags>(#\\d*))([a-zA-Z0-9\\s*]+)*(\\2)\\]");
        // Pattern regexFood = Pattern.compile("\\[(?<validTags>(#\\d+))([a-zA-Z\\s][a-zA-Z\\s0-9]+)*(\\1)\\]");
        //Pattern regexFood = Pattern.compile("\\[(?<validTags>(#\\d+))(.+?)(\\1)\\]");
        // Pattern regexFood = Pattern.compile("\\[(?<validTags>(#\\d+))([a-zA-Z\\s0-9]+)*(\\1)\\]");
        Pattern regexDrink = Pattern.compile("\\[(?<validTags>(#[a-z]*))([a-zA-Z0-9\\s*]+)*(\\2)\\]");
        //Pattern regexDrink = Pattern.compile("\\[(?<validTags>(#[a-z]))(.+?)(\\1)\\]");
        //Pattern regexDrink = Pattern.compile("\\[(?<validTags>(#[a-z]+))([A-Z][a-zA-Z\\s0-9]+)(\\1)\\]");
        Pattern regex = Pattern.compile("\\[.*?\\]");

        int numberOfInputLines = 0;
        int numberOfCrates = 0;

        List<String> foodsList = new ArrayList<>();
        List<String> drinkssList = new ArrayList<>();

        while (true) {
            String inputLine = reader.readLine();

            if ("Collect".equalsIgnoreCase(inputLine)) {
                break;
            }

            Matcher matcher = regex.matcher(inputLine);
            while (matcher.find()) {
                numberOfCrates++;
            }

            String validTask = "";
            Matcher matcherFood = regexFood.matcher(inputLine);
            Matcher matcherDrinks = regexDrink.matcher(inputLine);


            while (matcherFood.find()) {
                String crateFood = matcherFood.group();
                foodsList.add(crateFood);
            }

            while (matcherDrinks.find()) {
                String crateDrink = matcherDrinks.group();
                drinkssList.add(crateDrink);
            }

            numberOfInputLines++;
        }

        int n = numberOfCrates / numberOfInputLines;

        for (int i = 0; i < foodsList.size(); i++) {
            String currentCrate = foodsList.get(i);
            Matcher matcher = regexFood.matcher(currentCrate);


            if (matcher.find()) {
                String currentTag = matcher.group("validTags");

                String currentSupplyBody = matcher.group(3);
                if (currentTag.length() > 0 ) {
                    String tagWithoutFirstCharacter = currentTag.substring(1);

                    if (tagWithoutFirstCharacter.length() != n) {
                        foodsList.removeIf(x -> x.equals(currentCrate));
                        i--;
                    } else {
                        AmountOfFood += calculateFood(currentSupplyBody) *
                                tagWithoutFirstCharacter.length();
                    }
                }
            }
        }

        for (int i = 0; i < drinkssList.size(); i++) {
            String currentCrate = drinkssList.get(i);
            Matcher matcher = regexDrink.matcher(currentCrate);

            if (matcher.find()) {
                String currentTag = matcher.group("validTags");

                String currentSupplyBody = matcher.group(3);

                if (currentTag.length() > 0) {


                    String tagWithoutFirstCharacter = currentTag.substring(1);

                    if (tagWithoutFirstCharacter.length() != n) {
                        drinkssList.removeIf(x -> x.equals(currentCrate));
                        i--;
                    } else
                        AmountOfDrinks += calculateDrinks(currentSupplyBody, tagWithoutFirstCharacter);
                }
            }
        }

        if (foodsList.size() > 0 || drinkssList.size() > 0) {
            System.out.printf("Number of supply crates: %d%n", foodsList.size() + drinkssList.size());
            System.out.printf("Amount of food collected: %d%n", AmountOfFood);
            System.out.printf("Amount of drinks collected: %d%n", AmountOfDrinks);
        } else {
            System.out.println("No supplies found!");
        }

    }

    private static long calculateDrinks(String currentSupplyBody, String tagWithoutFirstCharacter) {
        long currentSumBody = 0L;
        long currentSumTag = 0L;
        for (int i = 0; i < currentSupplyBody.length(); i++) {
            currentSumBody += currentSupplyBody.charAt(i);
        }
        for (int i = 0; i < tagWithoutFirstCharacter.length(); i++) {
            currentSumTag += tagWithoutFirstCharacter.charAt(i);
        }
        return currentSumBody * currentSumTag;
    }

    private static long calculateFood(String currentSupplyBody) {
        long currentSum = 0L;
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < currentSupplyBody.length(); i++) {
            charSet.add(currentSupplyBody.charAt(i));
        }
        for (Character character : charSet) {
            currentSum += character;
        }

        return currentSum;
    }
}
