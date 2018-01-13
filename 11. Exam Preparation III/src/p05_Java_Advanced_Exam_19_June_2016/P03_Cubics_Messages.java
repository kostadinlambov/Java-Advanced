package p05_Java_Advanced_Exam_19_June_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_Cubics_Messages {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern regex = Pattern.compile("^(?<digitsBeforeMessage>\\d+)(?<message>[a-zA-Z]+)(?<charactersAfterTheMessage>[^a-zA-Z]*)$");
        while (true) {
            String message = reader.readLine();
            if ("Over!".equalsIgnoreCase(message)) {
                break;
            }
            String messageLength = reader.readLine();
            Matcher matcher = regex.matcher(message);

            if (matcher.find()&& matcher.group("message").length() == Integer.parseInt(messageLength)) {
                String messageString = matcher.group("message");
                String digitsBeforeMessage = matcher.group("digitsBeforeMessage");
                String charactersAfterTheMessage = matcher.group("charactersAfterTheMessage");

                String verifiedMessage = findVerificationCode(messageString, digitsBeforeMessage, charactersAfterTheMessage);
                if (verifiedMessage.equalsIgnoreCase(messageString + " == ")) {
                    System.out.println(message);
                } else {
                    System.out.println(verifiedMessage);
                }
            }
        }
    }

    private static String findVerificationCode(String messageString, String digitsBeforeMessage, String charactersAfterTheMessage) {

        StringBuilder sb = new StringBuilder();
        sb.append(messageString).append(" == ");

        for (int i = 0; i < digitsBeforeMessage.length(); i++) { {
                int currentDigit = digitsBeforeMessage.charAt(i) - '0';
                if (currentDigit >= 0 && currentDigit < messageString.length()) {
                    sb.append(messageString.charAt(currentDigit)+ "");
                } else {
                    sb.append(" ");
                }
            }
        }

        for (int i = 0; i < charactersAfterTheMessage.length(); i++) {
            if (Character.isDigit(charactersAfterTheMessage.charAt(i)) ) {
                int currentDigit = charactersAfterTheMessage.charAt(i) - '0';
                if (currentDigit >= 0 && currentDigit < messageString.length()) {
                    sb.append(messageString.charAt(currentDigit)  + "");
                } else {
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }
}
