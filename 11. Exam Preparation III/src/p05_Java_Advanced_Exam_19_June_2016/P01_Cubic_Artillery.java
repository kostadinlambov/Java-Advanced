package p05_Java_Advanced_Exam_19_June_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_Cubic_Artillery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int bunkerCapacity = Integer.parseInt(reader.readLine());

        Pattern regex = Pattern.compile("(?<bunkerName>\\w) (?<weapons>(\\d+)( \\d+)*)");

        while (true) {
            String tokens = reader.readLine();

            Matcher matcher = regex.matcher(tokens);

            while (matcher.find()) {

                String bunkerName = matcher.group("bunkerName");
                int[] weapons = Arrays.stream(matcher.group("weapons").split("\\s+"))
                        .mapToInt(Integer::valueOf).toArray();

                for (int i = 0; i < weapons.length; i++) {

                }
            }
        }
    }
}
