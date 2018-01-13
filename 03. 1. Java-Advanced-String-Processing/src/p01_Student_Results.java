import java.util.Arrays;
import java.util.Scanner;

public class p01_Student_Results {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("%-10s|%7s|%7s|%7s|%7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");

        String[] student = scanner.nextLine().split(" - ");

        String studentName = student[0];

        double[] studentGrades = Arrays.stream(student[1].split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double firstResult = studentGrades[0];
        double secondResult = studentGrades[1];
        double thirdResult = studentGrades[2];

        double average = (firstResult + secondResult + thirdResult) / 3;

        System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|%n", studentName, firstResult, secondResult, thirdResult, average);
    }
}
