import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p05_Chocolates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPackets = Integer.parseInt(reader.readLine());

        int[] packets = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfStudent = Integer.parseInt((reader.readLine()));

        Arrays.sort(packets);

        long diff = Integer.MAX_VALUE;
        long minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= numberOfPackets - numberOfStudent; i++) {
            diff = Math.abs(packets[i+numberOfStudent - 1] - packets[i]);
            if(diff < minDiff){
                minDiff = diff;
            }
        }
        if(packets.length >= numberOfStudent){
            System.out.printf("Min Difference is %d.", minDiff);
        }
    }
}
