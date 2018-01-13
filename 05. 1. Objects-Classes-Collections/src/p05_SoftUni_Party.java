import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class p05_SoftUni_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> guestsSet = new TreeSet<>();

        while(true){
            String reservations = reader.readLine();
            if(reservations.equals("PARTY")){
                break;
            }
            guestsSet.add(reservations);
        }

        while(true){
            String guestOnTheParty = reader.readLine();
            if(guestOnTheParty.equals("END")){
                break;
            }
            if(guestsSet.contains(guestOnTheParty)){
                guestsSet.remove(guestOnTheParty);
            }
        }

        List<String> vipGuests = new ArrayList<>();
        List<String> regularGuests = new ArrayList<>();

        for (String guest : guestsSet) {
            if(Character.isDigit(guest.charAt(0))){
                vipGuests.add(guest);
            }else{
                regularGuests.add(guest);
            }
        }

        System.out.println(guestsSet.size());
        for (String vipGuest : vipGuests) {
            System.out.println(vipGuest);
        }
        for (String regularGuest : regularGuests) {
            System.out.println(regularGuest);
        }
    }
}
