package string.problems;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    /*
    Write a Java Program to check if two Strings are Anagrams.
        Two String are called Anagrams when both Strings use the same characters but in different order.
        Example: "CAT" and "ACT", "ARMY" and "MARY", "FART" and "RAFT"
    */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st  string : ");
        String word1 = sc.next();
        System.out.println("Enter 2nd  string : ");
        String word2 = sc.next();

        char[] ch1 = word1.toCharArray();// converting string to characters array
        char[] ch2 = word2.toCharArray();// converting string to characters array


        Arrays.sort(ch1); // sorting characters array
        Arrays.sort(ch2); // sorting characters array

        boolean isAnagram = true;

        if(word1.length() == word2.length()){
            for(int i =0; i< word1.length(); i++){
                if(ch1[i] != ch2[i]){
                    isAnagram = false;
                    break;
                }
            }
            if(isAnagram){
                System.out.println("Anagram");
            }else {
                System.out.println(" Not Anagram");
            }
        }else {
            System.out.println("Not anagram");
        }




    }
}
