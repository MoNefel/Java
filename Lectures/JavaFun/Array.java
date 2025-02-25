package Lectures.JavaFun;

import java.util.*;
// iIn this class we will see Fixed Array, Array List and HashMaps
public class Array {
    public static void main(String[] args) {

        //Fixed Array
        //we can create array with both Primitive type and Object
        int[] arr = {1, 2, 4, 9, 7};
        System.out.println(arr[0]);
        arr[0] = 20;
        System.out.println(arr[0]);
        System.out.println("*********");


        //Array List :  .add(), .get(), .set()
        // we can create ArrayList only with Object Type(Integer, String ...)
        ArrayList<Integer> listArr = new ArrayList<>();
        listArr.add(10);
        listArr.add(20);
        listArr.add(30);
        //listArr.add("akamensi"); we can't add a String to an ArrayList of Integer
        System.out.println(listArr.get(1));
        listArr.set(1,45);
        System.out.println(listArr.get(1));
        System.out.println(listArr.size());
        System.out.println(listArr.isEmpty());
        System.out.println(listArr.contains(30));
        System.out.println(listArr.hashCode());
        for (int i = 0; i < listArr.size(); i++) {
            System.out.println(listArr.get(i));
        }

        System.out.println("*****HashMap***");
        //HashMaps
        HashMap<String, String>userMap = new HashMap<>();
        HashMap<String, Integer>user2Map = new HashMap<>();

        userMap.put("cool person", "address 1");
        userMap.put("crazy person", "address 2");
        System.out.println(userMap.get("cool person"));
        System.out.println(userMap.get("crazy person"));
        user2Map.put("key1", 22);
        user2Map.put("key2", 20);
        System.out.println(user2Map.get("key1"));
        System.out.println(user2Map.get("key2"));

        Set<String> keys = user2Map.keySet();
        for(String key : keys){
            System.out.println(key);
            System.out.println(user2Map.get(key));
        }
        
        Set<String> keyss = userMap.keySet();
        for(String key : keyss){
            System.out.println(key);
            System.out.println(userMap.get(key));
        }

    }
}
