import java.util.Scanner;

public class p03_Parse_Tags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        while (true) {

            int indexStartTag = inputLine.indexOf("<upcase>");
            if (indexStartTag == -1) {
                sb.append(inputLine);
                break;
            }

            int indexEndTag = inputLine.indexOf("</upcase>");

            String textInTag = inputLine.substring(indexStartTag + 8, indexEndTag).toUpperCase();

            sb.append(inputLine.substring(0, indexStartTag));
            sb.append(textInTag);

            inputLine = inputLine.substring(indexEndTag+9);
        }

        System.out.println(sb.toString());
    }
}
