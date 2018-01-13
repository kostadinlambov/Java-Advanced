import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p14_Sum_of_All_Values {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyString = scanner.nextLine();
        String textString = scanner.nextLine();
        String startKey = "";
        String endKey = "";

        Pattern regexStartKeyString = Pattern.compile("^([A-Za-z_]+)(?=\\d)");
        Matcher matcherStartKeyString = regexStartKeyString.matcher(keyString);

        if (matcherStartKeyString.find()) {
            startKey = matcherStartKeyString.group(1);
        } else {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        Pattern regexEndKeyString = Pattern.compile("(?<=\\d)([A-Za-z_]+)$");
        Matcher matcherEndKeyString = regexEndKeyString.matcher(keyString);

        if (matcherEndKeyString.find()) {
            endKey = matcherEndKeyString.group(1);
        } else {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String regexTextStringPattern = startKey + "([0-9.]+?)" + endKey;
        Pattern regexTextString = Pattern.compile(regexTextStringPattern);
        Matcher matcherTextString = regexTextString.matcher(textString);

        String value = "";
        double sum = 0.0;
        int countDoubleValues = 0;

        while (matcherTextString.find()) {

            sum += Double.parseDouble(matcherTextString.group(1));
            if (matcherTextString.group().contains(".")) {
                countDoubleValues++;
            }
        }

        if (sum > 0 && countDoubleValues > 0) {
            System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
        } else if (sum > 0 && countDoubleValues == 0) {
            System.out.printf("<p>The total value is: <em>%d</em></p>", (int) sum);
        } else if (sum == 0) {
            System.out.printf("<p>The total value is: <em>nothing</em></p>");
        }
    }
}
