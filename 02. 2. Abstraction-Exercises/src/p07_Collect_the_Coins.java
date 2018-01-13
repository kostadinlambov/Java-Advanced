import java.util.Scanner;

public class p07_Collect_the_Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 4;
        int cols = 1;

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String inputLine = scanner.nextLine();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = inputLine;
            }
        }

        String commands = scanner.nextLine();

        collectCoins(matrix, commands, rows, cols);

    }

    private static void collectCoins(String[][] matrix, String commands, int rows, int cols) {

        int rowPositon = 0;
        int charPosition = 0;
        int coinsCount = 0;
        int wallsHitCount = 0;

        for (int i = 0; i < commands.length(); i++) {
            switch (commands.charAt(i)) {
                case 'V':
                    rowPositon++;
                    if((rowPositon < rows) && (charPosition < matrix[rowPositon][cols-1].length())){
                        if(matrix[rowPositon][cols-1].charAt(charPosition)=='$'){
                            coinsCount++;
                        }
                    }else{
                        wallsHitCount++;
                        rowPositon--;
                    }
                    break;
                case '^':
                    rowPositon--;
                    if(rowPositon >= 0 && (charPosition < matrix[rowPositon][cols-1].length())){
                        if(matrix[rowPositon][cols-1].charAt(charPosition)=='$'){
                            coinsCount++;
                        }
                    }else{
                        wallsHitCount++;
                        rowPositon++;
                    }
                    break;
                case '>':
                    charPosition++;
                    if(charPosition < matrix[rowPositon][cols-1].length()){
                        if(matrix[rowPositon][cols-1].charAt(charPosition)=='$'){
                            coinsCount++;
                        }
                    }else{
                        wallsHitCount++;
                        charPosition--;
                    }
                    break;
                case '<':
                    charPosition--;
                    if(charPosition >= 0){
                        if(matrix[rowPositon][cols-1].charAt(charPosition)=='$'){
                            coinsCount++;
                        }
                    }else{
                        wallsHitCount++;
                        charPosition++;
                    }
                    break;
            }
        }

        System.out.printf("Coins = %d%n", coinsCount);
        System.out.printf("Walls = %d%n", wallsHitCount);
    }
}
