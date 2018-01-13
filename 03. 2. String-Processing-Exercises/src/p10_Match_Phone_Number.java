import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class p10_Match_Phone_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            Pattern regex = Pattern.compile("^\\+359(\\s|-)2\\1\\d{3}\\1\\d{4}$");
            Matcher matcher = regex.matcher(input);

            if (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
