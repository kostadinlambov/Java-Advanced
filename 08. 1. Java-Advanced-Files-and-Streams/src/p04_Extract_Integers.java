import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class p04_Extract_Integers {
    public static void main(String[] args) {
        String path = "C:\\Users\\valch\\Desktop\\08. Lab-Resources\\input.txt";
        String output = "C:\\Users\\valch\\Desktop\\08. Lab-Resources\\output.txt";

        try(Scanner scan = new Scanner(new FileInputStream(path)); PrintWriter out = new PrintWriter(new FileOutputStream(output))){
            while (scan.hasNext()){
                if(scan.hasNextInt()){
                    out.println(scan.nextInt());
                }
                scan.next();
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
