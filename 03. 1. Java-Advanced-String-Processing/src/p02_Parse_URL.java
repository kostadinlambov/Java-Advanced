import java.util.Scanner;

public class p02_Parse_URL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        String[] inputString = inputLine.split("://");

        if (inputString.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        String protocol = inputString[0];

        int indexServer = inputString[1].indexOf("/");
        String server = inputString[1].substring(0, indexServer);

        String resources = inputString[1].substring(indexServer + 1, inputString[1].length());

        System.out.printf("Protocol = %s%n", protocol);
        System.out.printf("Server = %s%n", server);
        System.out.printf("Resources = %s%n", resources);
    }
}
