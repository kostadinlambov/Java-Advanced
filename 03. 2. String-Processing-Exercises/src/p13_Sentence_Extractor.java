import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p13_Sentence_Extractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyWord = scanner.nextLine();
        String inputText = scanner.nextLine();

        String regexNew = "\\b[A-Z][^!.?]*?\\b" + keyWord + "\\b[^!.?]*?[.!?]";

        Pattern regex = Pattern.compile(regexNew);
        Matcher matcher = regex.matcher(inputText);

        if (keyWord.length() > 0 && inputText.length() > 0) {
            while (matcher.find()) {
                System.out.println(matcher.group(0));
            }
        }
    }
}
