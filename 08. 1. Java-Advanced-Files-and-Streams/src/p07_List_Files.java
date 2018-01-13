import java.io.File;

public class p07_List_Files {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\valch\\Desktop\\08. Lab-Resources\\Files-and-Streams");

        if(file.exists()){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if(!file1.isDirectory()){
                        System.out.printf("%s: %s%n", file1.getName(), file1.length());
                    }
                }
            }
        }
    }
}
