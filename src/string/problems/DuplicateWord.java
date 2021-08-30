package string.problems;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWord {

    public static void main(String[] args) {

        /*
         Write a java program to find the duplicate words and their number of occurrences in the string.
            Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        char c = ' ';
        String word = " ";
        int j = 1;

        Map<Integer, String> map = new HashMap<Integer, String>();
        Map<String, Integer> duplicates = new HashMap<String, Integer>();

        for (int i = 0; i < st.length(); i++){
             c = st.charAt(i);
             if( c != ' '){
                 word = word + c;
             }
             else {
                 map.put(j,word);
                 word = " ";
                 j++;
             }

                 }
//        for (Integer i : map.keySet()) {

//
//
//
//
//        }


        System.out.println(map);
    }

}
