package string.problems;

import java.util.Scanner;

public class Palindrome {

    public static void CheckPalindrom(String word){
        int len = word.length()-1;
        boolean isPlanindrom = true;

        char[] wd1 = word.toCharArray();
        char[] wd2 = new char[len+1];

        // reverse the word
        for(int i = 0; i<word.length(); i++){
           wd2[len] = wd1[i];
           len--;

        }

        //  check if the word and reverse word index elements matches or not

        for(int i = 0; i<word.length(); i++){

            if(wd1[i] != wd2[i]){
                isPlanindrom = false;
                System.out.println(word + " is not a Palindrom");
                break;
            }


        }
        if(isPlanindrom){
            System.out.println(word + " is a Palindrom");
        }

    }
    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called a palindrome.
            Example: MOM, DAD, MADAM are palindromes.

            Write a method to check if a given String is a palindrome or not.
         */
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to check palindrom: ");
        String word = sc.next();
        CheckPalindrom(word);

    }
}
