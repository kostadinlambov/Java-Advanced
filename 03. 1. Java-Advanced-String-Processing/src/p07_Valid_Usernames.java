import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07_Valid_Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countValid = 0;
        int countInvalid = 0;
        String validInvalidString = "";

        while(true){

            String input = scanner.nextLine();

            if (input.equals("END")){
                break;
            }

            Pattern regex = Pattern.compile("^([a-zA-z0-9_-]{3,16})$");
            Matcher matcher = regex.matcher(input);

            if(matcher.find()){
                countValid++;
                validInvalidString += "v";
               // System.out.println("valid");
            }else{
                countInvalid++;
                validInvalidString += "i";
                //System.out.println("invalid");
            }
        }

        if(countValid > 0){
            for (int i = 0; i <validInvalidString.length(); i++) {
                if(validInvalidString.charAt(i) == 'i'){
                    System.out.println("invalid");
                }else if (validInvalidString.charAt(i) == 'v'){
                    System.out.println("valid");
                }
            }
        }

    }
}