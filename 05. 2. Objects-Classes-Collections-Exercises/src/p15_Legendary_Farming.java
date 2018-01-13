import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class p15_Legendary_Farming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> keyMaterialsMap = new TreeMap<>();
        TreeMap<String, Integer> junkMap = new TreeMap<>();

        keyMaterialsMap.put("shards", 0);
        keyMaterialsMap.put("fragments", 0);
        keyMaterialsMap.put("motes", 0);

        boolean isLegendaryItemObtained = false;
        while (true) {

            String[] inputLine = reader.readLine().split("\\s+");

            int quantity = 0;
            String material = "";

            for (int i = 1; i <= inputLine.length; i += 2) {
                quantity = Integer.parseInt(inputLine[i-1]);
                material = inputLine[i].toLowerCase();

                if (material.equalsIgnoreCase("Shards")
                        || material.equalsIgnoreCase("Fragments")
                        || material.equalsIgnoreCase("Motes")){

                    keyMaterialsMap.put(material, keyMaterialsMap.get(material) + quantity);

                    if(keyMaterialsMap.get(material)>= 250){
                        keyMaterialsMap.put(material, keyMaterialsMap.get(material) - 250);
                        if(material.equalsIgnoreCase("Shards")){
                            System.out.println("Shadowmourne obtained!");
                            sortAndPrintKeyMaterials(keyMaterialsMap);
                            isLegendaryItemObtained = true;

                            break;
                        }else if(material.equalsIgnoreCase("Fragments")){
                            System.out.println("Valanyr obtained!");
                            sortAndPrintKeyMaterials(keyMaterialsMap);
                            isLegendaryItemObtained = true;
                            break;
                        }else if(material.equalsIgnoreCase("Motes")){
                            System.out.println("Dragonwrath obtained!");
                            sortAndPrintKeyMaterials(keyMaterialsMap);
                            isLegendaryItemObtained = true;
                            break;
                        }
                    }

                }else{
                    if(!junkMap.containsKey(material)){
                        junkMap.put(material, 0);
                    }
                    junkMap.put(material, junkMap.get(material) + quantity);
                }
            }
            if( isLegendaryItemObtained){
                break;
            }

        }

        for (String s : junkMap.keySet()) {
            System.out.println(s + ": " + junkMap.get(s));
        }
    }

    private static void sortAndPrintKeyMaterials(TreeMap<String, Integer> keyMaterialsMap) {

        Map<String, Integer> sortedKeyMaterialsMap = keyMaterialsMap.entrySet().stream()
                .filter(m -> m.getValue() < 250)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (String s : sortedKeyMaterialsMap.keySet()) {
            System.out.println(s + ": " + sortedKeyMaterialsMap.get(s));
        }

    }
}
