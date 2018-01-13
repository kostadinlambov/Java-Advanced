import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06_Extract_Tags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            String input = scanner.nextLine();

            if(input.equals("END")){
                return;
            }

            Pattern regex = Pattern.compile("<.*?>");
            Matcher matcher = regex.matcher(input);

            while(matcher.find()){
                System.out.println(matcher.group());
            }
        }
    }
}
