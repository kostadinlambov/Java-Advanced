import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p06_Overlapping_Intervals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = 2;

        int[][] intervalsMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] reminder = reader.readLine().split(",");
            for (int col = 0; col < cols; col++) {
                intervalsMatrix[row][col] = Integer.parseInt(reminder[col]);
            }
        }

        sortIntervalsMatrix(intervalsMatrix);

        System.out.println(hasOverlappingIntervals(intervalsMatrix));
    }

    private static boolean hasOverlappingIntervals(int[][] intervalsMatrix) {

        for (int i = 0; i < intervalsMatrix.length-1; i++) {
            int endOfFirstTimeInterval = intervalsMatrix[i][1];
            int startOfSecondTimeInterval = intervalsMatrix[i+1][0];
            if( endOfFirstTimeInterval >= startOfSecondTimeInterval){
                return true;
            }
        }
        return false;
    }

    private static void sortIntervalsMatrix(int[][] intervalsMatrix) {
        //Bubble sort
        boolean swapped = true;
        do{
            swapped = false;
            for (int i = 0; i < intervalsMatrix.length-1; i++) {

                if(intervalsMatrix[i][0] > intervalsMatrix[i+1][0]){
                    int tempRow = intervalsMatrix[i][0];
                    int tempCol = intervalsMatrix[i][1];
                    intervalsMatrix[i][0] = intervalsMatrix[i+1][0];
                    intervalsMatrix[i][1] = intervalsMatrix[i+1][1];
                    intervalsMatrix[i+1][0] = tempRow;
                    intervalsMatrix[i+1][1] = tempCol;

                    swapped = true;
                }
            }
        }while(swapped == true);
    }
}

