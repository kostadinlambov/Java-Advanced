import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p15_Valid_Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        Pattern regex = Pattern.compile("\\b([a-zA-Z]\\w{2,24})\\b");
        Matcher matcher = regex.matcher(inputLine);

        List<String> matchesList = new ArrayList<>();

        while(matcher.find()){
            matchesList.add(matcher.group());
        }

        int sum = 0;
        int biggestSum = Integer.MIN_VALUE;
        String firtsUserName = "";
        String secondUserName = "";

        for (int i = 0; i < matchesList.size()-1; i++) {

            sum = matchesList.get(i).length() + matchesList.get(i+1).length();
            if (sum > biggestSum){
                biggestSum = sum;
                firtsUserName = matchesList.get(i);
                secondUserName = matchesList.get(i+1);
            }
        }

        System.out.println(firtsUserName);
        System.out.println(secondUserName);
    }
}
