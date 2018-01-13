import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_Extract_Hyperlinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        while (true) {
            String inputLine = scanner.nextLine();
            if (inputLine.equals("END")) {
                break;
            }
            sb.append(inputLine);
        }

        String inputText = sb.toString();

        Pattern regex = Pattern.compile("<a\\s+([^>]+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)\"|([^\\s>]*|\\s))[^>]*>");
        Matcher matcher = regex.matcher(inputText);

        while (matcher.find()) {
            for (int i = 5; i >= 0 ; i--) {
                String result = matcher.group(i);
                if(result != null){
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
