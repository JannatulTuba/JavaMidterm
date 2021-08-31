package datastructure;

import java.util.*;

public class UseMap {


    private static void  ForEach( Map<Integer, List<String>> mp){
        System.out.println("******For Each Loop*********");
//        for (Map.Entry<Integer, List<String>> entry : Mp.entrySet()) {
//            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
//        }

        mp.forEach((id, studyMaterialList) -> {
            System.out.println("Key : " + id + " value : " + studyMaterialList);
        });


    }

    private static void  WhileLoop( Map<Integer, List<String>> mp){
        System.out.println("******While Loop*********");
        int size = mp.size()-1;
        int i =1;

        Iterator<Integer> iterator = mp.keySet().iterator();

        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("Key : " + key + " value : " + mp.get(key));
        }
        }


    public static void main(String[] args) {
        /*
         * Demonstrate how to use Map that includes storing and retrieving elements.
         * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
         * Use For-Each loop and While-loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        Map<Integer, List<String>> mapp = new HashMap<Integer, List<String>>();

        List<String> list = new ArrayList<String>();

        mapp.put(1,list);
        list.add("Book");
        list.add("Pen");
        list.add("Penciel");
        list.add("Notebook");

        mapp.put(2,list);
        list.add("Laptop");
        list.add("PC");
        list.add("Headphone");
        list.add("Mouse");

        System.out.println(mapp);

        WhileLoop(mapp);
        ForEach(mapp);
    }
}
