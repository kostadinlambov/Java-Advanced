import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class p04_Parking_Lot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        HashSet<String> carNumbersSet = new HashSet<>();
        while (true) {
            String[] inputLine = reader.readLine().split(", ");

            if (inputLine[0].equals("END")) {
                break;
            }

            if (inputLine[0].equals("IN")) {
                carNumbersSet.add(inputLine[1]);
            } else {
                carNumbersSet.remove(inputLine[1]);
            }
        }

        if (carNumbersSet.size() > 0) {
            for (String carNumber : carNumbersSet) {
                System.out.println(carNumber);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}

