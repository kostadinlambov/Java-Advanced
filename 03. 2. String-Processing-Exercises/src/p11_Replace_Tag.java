import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p11_Replace_Tag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        while(true){
            String inputLine = scanner.nextLine();
            if(inputLine.equals("END")){
                break;
            }
            sb.append(inputLine + System.lineSeparator());
        }

        String inputText = sb.toString();

        Pattern regex = Pattern.compile("<a href=\\\".+\\\">([\\s\\S]+?<\\/a>)?");
        Matcher matcher = regex.matcher(inputText);

        String replacement= "";

        if(matcher.find()){
            replacement = matcher.group(0)
                    .replace("<a", "[URL")
                    .replace(">","]")
                    .replace("</a", "[/URL");
            inputText= inputText.replace(matcher.group(0), replacement);
        }

        System.out.println(inputText);
    }
}
