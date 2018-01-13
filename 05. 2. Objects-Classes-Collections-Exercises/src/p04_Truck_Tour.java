import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;

public class p04_Truck_Tour {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> allPumps = new ArrayDeque<>();

        int numberOfPumps = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfPumps; i++) {
            allPumps.addLast(reader.readLine());
        }
        int counter = 0;
        while (true) {
            Long totalFuel = 0L;
            boolean found = true;
            for (String pump : allPumps) {
                Long currentFuel = Long.valueOf(pump.split(" ")[0]);
                Long distance = Long.valueOf(pump.split(" ")[1]);
                totalFuel += currentFuel;
                if (totalFuel < distance) {
                    found = false;
                    break;
                }

                totalFuel -= distance;
            }

            if (found) {
                System.out.println(counter);
                break;
            }
            allPumps.addLast(allPumps.pop());
            counter++;
        }
    }
}
