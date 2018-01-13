import java.util.Scanner;

public class p01_Count_Substring_Occurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String text = scanner.nextLine().toLowerCase();
            String stringToFind = scanner.nextLine().toLowerCase();

            int count = 0;
            while(true){

                int indexOfMatch = text.indexOf(stringToFind);
                if(indexOfMatch == -1){
                    break;
                }

                count++;

                text = text.substring(indexOfMatch+1);
            }

        System.out.println(count);
    }
}
