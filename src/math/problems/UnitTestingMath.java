package math.problems;
import math.problems.Fibonacci;
import math.problems.FindLowestDifference;
import math.problems.PrimeNumber;
import math.problems.Pattern;
import org.testng.Assert;

public class UnitTestingMath {

    public static void main(String[] args) {
        // Apply unit testing from each class contained within this package, here.

        //Factorial
        Factorial factorialObj = new Factorial();
       int result =  factorialObj.factorial(5);
        try {
            Assert. assertEquals(120, result, "ARRAY IS NOT SORTED Using Insertion Sort.. YET!\n***YOU GOT THIS!***");// Display message when error founds

        } catch (Exception ex) {
            ex.getMessage();
        }

//        //Fibonacci
        int[] array3 = {0 ,1, 1, 2, 3, 5};
        int[] array4= Fibonacci.Fibonacci(5);
        try {
            Assert. assertEquals(array3,array4, "Test Failed for Fibonacci");// Display message when error founds

        } catch (Exception ex) {
            ex.getMessage();
        }

        //LowesNumber
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19};

        int result3 =  FindLowestDifference.LowestDifference(array1,array2);
        try {
            Assert. assertEquals(1, result3, "Test Failed for Lowest Number Array");// Display message when error founds

        } catch (Exception ex) {
            ex.getMessage();
        }

    }
}
