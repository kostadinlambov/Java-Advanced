import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p10_Semantic_HTML_85_100 {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = reader.readLine();
            if ("END".equals(input)) {
                break;
            }

            lines.add(input);
        }

        Pattern pattern = Pattern.compile("<div\\s+.*(?<remove>(class|id|Id)\\s*=\\s*\"(?<target>[a-z]+)\").*>");
        Pattern pattern1 = Pattern.compile("<\\/div>\\s+<!--\\s*(?<target>[a-z]+)\\s*-->");
        Pattern pattern2 = Pattern.compile("<(.*?)>");

        for (int i = 0; i < lines.size(); i++) {
            Matcher matcher = pattern.matcher(lines.get(i));
            Matcher matcher1 = pattern1.matcher(lines.get(i));
            if (matcher.find()) {
                String newLine = lines.get(i)
                        .replace("<div", "<" + matcher.group("target"))
                        .replace(matcher.group("remove"), "");

                String newLine2 = newLine.replaceAll("\\s+>", ">");
                lines.set(i, newLine2);
            }
            if (matcher1.find()) {
                String newLine = lines.get(i)
                        .replace(matcher1.group(), "</" + matcher1.group("target") + ">");
                String newLine2 = newLine.replaceAll("\\s+>", ">");
                lines.set(i, newLine2);
            }
            Matcher matcher2 = pattern2.matcher(lines.get(i));
            if (matcher2.find()) {
                String newLine = lines.get(i);
                String newLine2 = matcher2.group()
                        .replaceAll("\\s{2,}", " ");
                newLine = newLine.replace(matcher2.group(), newLine2);
                lines.set(i, newLine);
            }
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
