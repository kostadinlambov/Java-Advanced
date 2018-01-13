import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class p03_Copy_Bytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\valch\\Desktop\\08. Lab-Resources\\input.txt";
        String output = "C:\\Users\\valch\\Desktop\\08. Lab-Resources\\output.txt";

        try (InputStream in = new FileInputStream(path); OutputStream out = new FileOutputStream(output);){
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0){
                if(oneByte == 10 || oneByte == 32){
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }
            }
        } catch (Exception e){
            System.out.println();
        }
    }
}
