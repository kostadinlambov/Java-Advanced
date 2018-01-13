import java.util.Arrays;
import java.util.Scanner;

public class p02_Triangle_Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstPointCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondPointCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] thirdPointCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int triangleArea = calculateArea(firstPointCoordinates, secondPointCoordinates, thirdPointCoordinates);

        System.out.println(triangleArea);
    }

    private static int calculateArea(int[] firstPointCoordinates, int[] secondPointCoordinates, int[] thirdPointCoordinates) {

        int area = Math.abs(((firstPointCoordinates[0] * (secondPointCoordinates[1] - thirdPointCoordinates[1])) +
                (secondPointCoordinates[0] * (thirdPointCoordinates[1] - firstPointCoordinates[1])) +
                (thirdPointCoordinates[0] * (firstPointCoordinates[1] - secondPointCoordinates[1])))/2);

        return area;
    }
}
