import java.util.Scanner;

public class p11_Game_of_Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPlayers = Integer.parseInt(scanner.nextLine());

        int maxScore = Integer.MIN_VALUE;
        String winnerName = "";

        for (int i = 0; i < numOfPlayers; i++) {

            String name = scanner.nextLine();
            int initialScore = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < name.length(); j++) {
                if(name.charAt(j) % 2 == 0){
                    initialScore += name.charAt(j);
                }else{
                    initialScore -= name.charAt(j);
                }
            }

            if(initialScore > maxScore){
                maxScore = initialScore;
                winnerName = name;
            }
        }

        System.out.printf("The winner is %s - %d points", winnerName, maxScore);
    }
}
