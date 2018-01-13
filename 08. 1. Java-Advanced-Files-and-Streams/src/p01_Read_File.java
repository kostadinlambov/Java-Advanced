import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_Read_File {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String path = "C:\\Users\\valch\\Desktop\\08. Lab-Resources\\input.txt";

        try( FileInputStream fis = new FileInputStream(path)){
            int oneByte = fis.read();
            while (oneByte >= 0) {
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte = fis.read();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
