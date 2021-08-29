package math.problems;


import java.util.Arrays;

public class FindLowestDifference {


    public static void LowestDifference(int array1[], int array2[]){

        int lowestDiff = array1[0]-array2[0];
        int diff = 0;

        for(int i = 0; i<array1.length; i++){

            for(int j = 0; j<array2.length; j++){

                diff = array2[j] - array1[i];

                if(Math.abs(diff)<Math.abs(lowestDiff)){
                    lowestDiff = diff;
                }
            }
        }
        System.out.println(Math.abs(lowestDiff));

    }
    public static void main(String[] args) {
        /*
         Write a method to return the the lowest difference between these two arrays
            HINT: The lowest difference between these arrays is 1
        */

        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19};

        LowestDifference(array1,array2);

    }

}
