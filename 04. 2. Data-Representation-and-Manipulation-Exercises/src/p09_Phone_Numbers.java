import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09_Phone_Numbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputSb = new StringBuilder();
        while (true) {
            String inputLine = reader.readLine();
            if (inputLine.equals("END")) {
                break;
            }
            inputSb.append(inputLine);
        }

        System.out.println();

        Pattern regex = Pattern
                .compile("[^\\\\u0000-\\\\u007F]*([A-Z][]A-Za-z]*)([^A-Za-z\\+]*?)(\\+?\\d[\\d\\(\\)\\/.,\\s-]*\\d)[^\\\\u0000-\\\\u007F]*");
        Matcher matcher = regex.matcher(inputSb);

        StringBuilder matchesPrint = new StringBuilder("<ol>");
        int matcherCount = 0;
        while (matcher.find()) {
            matcherCount++;
            String name = matcher.group(1);
            String phoneNumber = matcher.group(3).replaceAll("[\\(\\)\\/.,\\s-]", "");
            String currentMatch = String.format("<li><b>%s:</b> %s</li>", name, phoneNumber);
            matchesPrint.append(currentMatch);
        }

        if(matcherCount == 0){
            System.out.println("<p>No matches!</p>");
        }else{
            matchesPrint.append("</ol>");
            System.out.println(matchesPrint.toString());
        }
    }
}
