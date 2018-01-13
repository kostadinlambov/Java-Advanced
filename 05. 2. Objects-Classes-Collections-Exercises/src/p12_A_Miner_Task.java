import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class p12_A_Miner_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> resources = new HashMap<>();

        String nameOFResource = "";
        int quantity = 0;
        int count = 1;

        while (true) {
            String inputLine = reader.readLine();

            if(inputLine.equalsIgnoreCase("stop")){
                break;
            }

            if (count % 2 != 0) {
                nameOFResource = inputLine;
                if (!resources.containsKey(nameOFResource)) {
                    resources.put(nameOFResource, 0);
                }
            } else {
                quantity = Integer.parseInt(inputLine);
                resources.put(nameOFResource, resources.get(nameOFResource) + quantity);
            }

            count++;
        }


        for(HashMap.Entry<String,Integer> resource: resources.entrySet())
            System.out.printf("%s -> %d%n", resource.getKey(), resource.getValue());
    }
}
