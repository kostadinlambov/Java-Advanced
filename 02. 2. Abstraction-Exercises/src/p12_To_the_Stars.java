import java.util.Scanner;

public class p12_To_the_Stars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstStarSystem = scanner.nextLine().split("\\s+");

        String firstStarSystemName = firstStarSystem[0].toLowerCase();
        double firstStarSystemInitialCoordinateX = Double.parseDouble(firstStarSystem[1]);
        double firstStarSystemInitialCoordinateY = Double.parseDouble(firstStarSystem[2]);

        String[] secondStarSystem = scanner.nextLine().split("\\s+");

        String secondStarSystemName = secondStarSystem[0].toLowerCase();
        double secondStarSystemInitialCoordinateX = Double.parseDouble(secondStarSystem[1]);
        double secondStarSystemInitialCoordinateY = Double.parseDouble(secondStarSystem[2]);

        String[] thirdStarSystem = scanner.nextLine().split("\\s+");

        String thirdStarSystemName = thirdStarSystem[0].toLowerCase();
        double thirdStarSystemInitialCoordinateX = Double.parseDouble(thirdStarSystem[1]);
        double thirdStarSystemInitialCoordinateY = Double.parseDouble(thirdStarSystem[2]);

        String[] initialCoordinates = scanner.nextLine().split("\\s+");

        double normandyCoordinateX = Double.parseDouble(initialCoordinates[0]);
        double normandyCoordinateY = Double.parseDouble(initialCoordinates[1]);

        int numberOfTurns = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfTurns + 1; i++) {

            if (checkPositionToFirstStar(normandyCoordinateX, normandyCoordinateY,
                    firstStarSystemInitialCoordinateX, firstStarSystemInitialCoordinateY)) {
                System.out.println(firstStarSystemName);
            } else if (checkPositionToSecondStar(normandyCoordinateX, normandyCoordinateY,
                    secondStarSystemInitialCoordinateX, secondStarSystemInitialCoordinateY)) {
                System.out.println(secondStarSystemName);
            } else if (checkPositionToThirdStar(normandyCoordinateX, normandyCoordinateY,
                    thirdStarSystemInitialCoordinateX, thirdStarSystemInitialCoordinateY)) {
                System.out.println(thirdStarSystemName);
            } else {
                System.out.println("space");
            }

            normandyCoordinateY = normandyCoordinateY + 1.0;
        }
    }

    private static boolean checkPositionToThirdStar(double normandyCoordinateX, double normandyCoordinateY,
                                                    double thirdStarSystemInitialCoordinateX,
                                                    double thirdStarSystemInitialCoordinateY) {

        double thirdStarRangeMinX = thirdStarSystemInitialCoordinateX - 1.0;
        double thirdStarRangeMinY = thirdStarSystemInitialCoordinateY - 1.0;
        double thirdStarRangeMaxX = thirdStarSystemInitialCoordinateX + 1.0;
        double thirdStarRangeMaxY = thirdStarSystemInitialCoordinateY + 1.0;

        if (normandyCoordinateX >= thirdStarRangeMinX && normandyCoordinateX <= thirdStarRangeMaxX &&
                normandyCoordinateY >= thirdStarRangeMinY && normandyCoordinateY <= thirdStarRangeMaxY) {
            return true;
        }

        return false;
    }

    private static boolean checkPositionToSecondStar(double normandyCoordinateX, double normandyCoordinateY,
                                                     double secondStarSystemInitialCoordinateX,
                                                          double secondStarSystemInitialCoordinateY) {

        double secondStarRangeMinX = secondStarSystemInitialCoordinateX - 1.0;
        double secondStarRangeMinY = secondStarSystemInitialCoordinateY - 1.0;
        double secondStarRangeMaxX = secondStarSystemInitialCoordinateX + 1.0;
        double secondStarRangeMaxY = secondStarSystemInitialCoordinateY + 1.0;

        if (normandyCoordinateX >= secondStarRangeMinX && normandyCoordinateX <= secondStarRangeMaxX &&
                normandyCoordinateY >= secondStarRangeMinY && normandyCoordinateY <= secondStarRangeMaxY) {
            return true;
        }

        return false;
    }

    private static boolean checkPositionToFirstStar(double normandyCoordinateX, double normandyCoordinateY,
                                                    double firstStarSystemInitialCoordinateX,
                                                    double firstStarSystemInitialCoordinateY) {

        double firstStarRangeMinX = firstStarSystemInitialCoordinateX - 1.0;
        double firstStarRangeMinY = firstStarSystemInitialCoordinateY - 1.0;
        double firstStarRangeMaxX = firstStarSystemInitialCoordinateX + 1.0;
        double firstStarRangeMaxY = firstStarSystemInitialCoordinateY + 1.0;

        if (normandyCoordinateX >= firstStarRangeMinX && normandyCoordinateX <= firstStarRangeMaxX &&
                normandyCoordinateY >= firstStarRangeMinY && normandyCoordinateY <= firstStarRangeMaxY) {
            return true;
        }

        return false;
    }
}
