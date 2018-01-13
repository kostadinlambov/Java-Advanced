import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class p06_Sort_Lines {
    public static void main(String[] args) {

        Path path = Paths.get("C:\\Users\\valch\\Desktop\\08. Lab-Resources\\input.txt");
        Path output = Paths.get("C:\\Users\\valch\\Desktop\\08. Lab-Resources\\output.txt");
//        String path = "C:\\Users\\valch\\Desktop\\08. Lab-Resources\\input.txt";
//        String output = "C:\\Users\\valch\\Desktop\\08. Lab-Resources\\output.txt";

        try{
            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);
            Files.write(output, lines);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
