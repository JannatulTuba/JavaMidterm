package string.problems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {

    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below
         Should return "10 biological"
         */
        String s = "Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);



    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";
        int j=1;
        char[] ch = wordGiven.toCharArray();

        // Implement here
        for(int i=0; i<wordGiven.length();i++){

            if(ch[i] == ' '){
                map.put(j-1,st);
                st = "";
                j = 1;
            }
            else {
                st = st+ch[i];
                j++;
            }

        }


       int largest =  map.get(1).length();
        String largestString = " ";

        for (Integer i : map.keySet()) {

          if( map.get(i).length() > largest){
              largest = map.get(i).length();
              largestString = map.get(i);
          }

        }
        System.out.println(largest +  " "+  largestString);


        return map;
    }
}
