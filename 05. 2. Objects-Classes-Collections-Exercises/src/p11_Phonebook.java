import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p11_Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> phoneBook = new HashMap<>();

        while (true) {
            String[] peopleData = reader.readLine().split("-");

            if(peopleData[0].equalsIgnoreCase("search")){
                break;
            }
            String name = peopleData[0];
            String number = peopleData[1];

            phoneBook.put(name, number);
        }

        while(true){
            String usersSearch = reader.readLine();

            if(usersSearch.equalsIgnoreCase("stop")){
                break;
            }

            if(phoneBook.containsKey(usersSearch)){
                System.out.printf("%s -> %s%n", usersSearch, phoneBook.get(usersSearch));
            }else{
                System.out.printf("Contact %s does not exist.%n",usersSearch);
            }
        }
    }
}
