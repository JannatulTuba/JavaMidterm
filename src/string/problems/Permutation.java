package string.problems;

import java.util.Scanner;

public class Permutation {

    //  print all the permutations of given string
    static void PrintStringPermutation(String str,    String result )
    {

        // check if string is empty or not
        if (str.length() == 0) {
            System.out.print(result + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding the ith character
             String ros = str.substring(0, i) + str.substring(i + 1);

//            System.out.println(str.substring(i + 1));//b when i =0
//            System.out.println(str.substring(0, i));//c when i = 0
//            System.out.println(ros);//bc when i =0

            // Recurvise call
            PrintStringPermutation(ros, result + ch);
        }
    }


    public static void main(String[] args) {

        /*
        Permutation of String "ABC" is "ABC" "BAC" "BCA" "ACB" "CAB" "CBA".

        Write Java program to compute all permutations of any given String
         */


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String word = sc.next();
        PrintStringPermutation(word," ");
    }



}
