package math.problems;

import java.util.Scanner;

public class Fibonacci {

    /*
    Write a method that will print or return at least 40 Fibonacci numbers

      0,1,1,2,3,5,8,13

   #  0 1 2 3 4 5 6 7
   #  0,1,1,2,3,5,8,13

     */

    public static  int[] Fibonacci(int num){
        int i = 0;

        int lastResult= 1;
        int secondLastResult = 0;
        int result = 0;
        int[] arr= new int[num+1];
        while ( i <= num){

            if ( i ==0 || i == 1){
                result = i;
            }
            else {
                result = lastResult + secondLastResult;

            }
            arr[i] = result;
            System.out.print(result + " ");
            secondLastResult =  lastResult;
            lastResult = result;
            i++;

        }
return arr;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter any number: ");
        int number = input.nextInt();
        System.out.println("Fibonacci series upto "+ number +" : ");
        Fibonacci(number);
    }


}
