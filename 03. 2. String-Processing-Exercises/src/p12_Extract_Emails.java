import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p12_Extract_Emails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        Pattern regex = Pattern
                .compile("(^|(?<=\\s))[a-zA-Z]\\w*(?:[.-]\\w+)*@\\w+(?:[.-]\\w+)+($|(?=,)|(?=\\s)|(?=\\.))");
        Matcher matcher = regex.matcher(inputLine);

        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
