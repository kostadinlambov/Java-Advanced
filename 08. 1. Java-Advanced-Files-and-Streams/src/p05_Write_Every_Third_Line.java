import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class p05_Write_Every_Third_Line {
    public static void main(String[] args) {
        String path = "C:\\Users\\valch\\Desktop\\08. Lab-Resources\\input.txt";
        String output = "C:\\Users\\valch\\Desktop\\08. Lab-Resources\\output.txt";

        try(BufferedReader bf = new BufferedReader(new FileReader(path)); PrintWriter out = new PrintWriter(new FileWriter(output))){
            int counter = 1;
            String line = bf.readLine();
            while (line != null){
                if(counter%3 == 0){
                    out.println(line);
                }
                counter++;
                line = bf.readLine();
            }
        } catch (Exception e ){
            System.out.println(e);
        }
    }
}
