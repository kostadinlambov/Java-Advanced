import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_Series_of_Letters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern regex = Pattern.compile("(\\w)\\1*");
        Matcher matcher = regex.matcher(input);

        String replaced = "";
        while(matcher.find()){
            replaced = matcher.replaceAll("$1");
        }
        System.out.println(replaced);
    }
}
