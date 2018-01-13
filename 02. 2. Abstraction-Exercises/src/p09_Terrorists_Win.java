import java.util.Scanner;

public class p09_Terrorists_Win {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        while (true) {
            int startIndex = inputLine.indexOf("|");

            if (startIndex == -1) {
                break;
            }

            String inputLineAfterExplosion = inputLine;

            inputLine = inputLine.substring(startIndex + 1);
            int endIndex = inputLine.indexOf("|");
            inputLine = inputLine.substring(0, endIndex);

            int sumOfDigits = 0;

            for (int i = 0; i < inputLine.length(); i++) {
                sumOfDigits += inputLine.charAt(i);
            }

            int bombPower = 0;

            String sumOfDigitsString = Integer.toString(sumOfDigits);
            bombPower = Integer.parseInt(sumOfDigitsString.substring(sumOfDigitsString.length() - 1));

            StringBuilder bombPowerReplacement = new StringBuilder();


            int bombLength = inputLine.length() + 2 + bombPower * 2;

            int beginIndexReplacement = startIndex - bombPower;
            int endIndexReplacement = beginIndexReplacement + bombLength;

            if (beginIndexReplacement < 0) {
                beginIndexReplacement = 0;
            }
            if (endIndexReplacement > inputLineAfterExplosion.length()) {
                endIndexReplacement = inputLineAfterExplosion.length();
            }

            bombLength = endIndexReplacement - beginIndexReplacement;

            for (int i = 0; i < bombLength; i++) {
                bombPowerReplacement.append(".");
            }

            String partToReplace = inputLineAfterExplosion.substring(beginIndexReplacement, endIndexReplacement);
            inputLineAfterExplosion = inputLineAfterExplosion.replace(partToReplace, bombPowerReplacement.toString());

            inputLine = inputLineAfterExplosion;

        }

        System.out.println(inputLine);
    }
}
