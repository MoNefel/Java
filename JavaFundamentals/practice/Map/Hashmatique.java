package JavaFundamentals.practice.Map;

import java.util.HashMap;


public class Hashmatique {
    /*Create a trackList of type HashMap.
    Add in at least 4 songs that are stored by title.
    Pull out one of the songs by its track title.
    Print out all the track names and lyrics in the format 'Track: Lyrics'. */
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Marley", "One Love");
        map.put("Tupac", "Change");
        map.put("Nas", "NewYork");
        map.put("Eminem", "8 Miles");
        System.out.println(map.get("Marley"));

        for(String key : map.keySet()){
            System.out.println(String.format("Singer : %s  -  Song : %s", key, map.get(key)));
        }
    }
}
