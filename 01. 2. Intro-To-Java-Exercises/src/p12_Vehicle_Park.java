import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p12_Vehicle_Park {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] allVehicles = scanner.nextLine().split("\\s+");

        List<String> vehicleList = new ArrayList<>();

        vehicleList.addAll(Arrays.asList(allVehicles));


        int count = 0;
        String requestForVehicles = scanner.nextLine();

        while(!requestForVehicles.equals("End of customers!")){

            int hasSellCount = 0;
            String[] tokens =requestForVehicles.split("\\s+");


            String vehicleType = tokens[0].toLowerCase();
            int numberOfTheSeats = Integer.parseInt(tokens[2]);


            for (String vehicle : vehicleList) {

                int seats = Integer.parseInt(vehicle.substring(1));

                if (vehicle.charAt(0) == vehicleType.charAt(0) &&
                        numberOfTheSeats == seats){
                    int price = numberOfTheSeats * vehicle.charAt(0);
                    System.out.printf("Yes, sold for %d$%n", price);
                    vehicleList.remove(vehicle);
                    count++;
                    hasSellCount++;
                    break;
                }
            }

            if (hasSellCount == 0){
                System.out.println("No");
            }

            requestForVehicles = scanner.nextLine();
        }

        System.out.println("Vehicles left: "+ String.join(", ", vehicleList));
        System.out.printf("Vehicles sold: %d", count);
    }
}
