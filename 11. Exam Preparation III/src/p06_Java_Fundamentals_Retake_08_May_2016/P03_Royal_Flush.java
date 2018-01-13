package p06_Java_Fundamentals_Retake_08_May_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P03_Royal_Flush {
    private static int flushesCount = 0;
    private static List<String> listOfCards = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfLines = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfLines; i++) {
            String inputLine = reader.readLine();
            sb.append(inputLine);
        }

        parseInput(sb);

        int royalFlushCount = 1;
        for (int i = 0; i < listOfCards.size() - 1; i++) {

            String currentCardValue = listOfCards.get(i).substring(0, listOfCards.get(i).length() - 1);
            String currentCardSuit = listOfCards.get(i).substring(listOfCards.get(i).length() - 1);

            String nextCardValue = listOfCards.get(i + 1).substring(0, listOfCards.get(i + 1).length() - 1);
            String nextCardSuit = listOfCards.get(i + 1).substring(listOfCards.get(i + 1).length() - 1);

            String neededNextCardValue = calculateNextCardValue(currentCardValue);

            if (nextCardValue.equals(neededNextCardValue) && nextCardSuit.equals(currentCardSuit)) {
                royalFlushCount++;
                if (royalFlushCount == 5) {
                    printRoyalFlush(currentCardSuit);
                    i++;
                    royalFlushCount = 1;
                }
            } else if (!nextCardValue.equals(neededNextCardValue) && !nextCardSuit.equals(currentCardSuit)) {

                listOfCards.remove(i + 1);
                i--;
            } else if (!nextCardValue.equals(neededNextCardValue) && nextCardSuit.equals(currentCardSuit)) {
                royalFlushCount = 1;
            }
        }

        System.out.println("Royal’s Royal Flushes – " + flushesCount);

    }

    private static void parseInput(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i += 2) {
            boolean isCardTen = false;
            String currentCardValue = String.valueOf(sb.charAt(i));
            if (currentCardValue.equalsIgnoreCase("1")) {
                currentCardValue = "10";
                isCardTen = true;
                i++;
            }
            String currentCardSuit = String.valueOf(sb.charAt(i + 1));
            String currentCard = currentCardValue + currentCardSuit;
            listOfCards.add(currentCard);
        }

        Collections.sort(listOfCards);
    }

    private static void printRoyalFlush(String currentCardSuit) {
        switch (currentCardSuit) {
            case "c":
                System.out.println("Royal Flush Found – Clubs");
                break;
            case "d":
                System.out.println("Royal Flush Found – Diamonds");
                break;
            case "h":
                System.out.println("Royal Flush Found – Hearts ");
                break;
            case "s":
                System.out.println("Royal Flush Found – Spades");
                break;
        }
        flushesCount++;
    }

    private static String calculateNextCardValue(String currentCardValue) {

        switch (currentCardValue) {
            case "2":
                return "3";
            case "3":
                return "4";
            case "4":
                return "5";
            case "5":
                return "6";
            case "6":
                return "7";
            case "7":
                return "8";
            case "8":
                return "9";
            case "9":
                return "10";
            case "10":
                return "J";
            case "J":
                return "Q";
            case "Q":
                return "K";
            case "K":
                return "A";
            case "A":
                return "2";
        }
        return null;
    }
}
