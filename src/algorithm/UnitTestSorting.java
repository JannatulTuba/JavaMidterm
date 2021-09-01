package algorithm;

import org.testng.Assert;

public class UnitTestSorting {

    /*
      This class is used to help with unit testing of sorting algorithms from the Sort class
     */
    public static void main(String[] args) {
        int[] unSortedArray = {6, 9, 2, 5, 1, 0, 4};
        int[] sortedArray = {0, 1, 2, 4, 5, 6, 9};
        System.out.println("If the test pass, you will see no message but if it fails, the program will show error message");
        // Create instance of Sort class
        Sort sort = new Sort();

        // Pass the unsorted array to selectionSort() method from Sort class


        sort.selectionSort(unSortedArray);

        // Verify if the unsorted array is sorted by the selectionSort() method
        try {

        Assert. assertEquals(sortedArray, unSortedArray, "ARRAY IS NOT SORTED... YET!\n***YOU GOT THIS!***");// Display message when error founds

        } catch (Exception ex) {

            ex.getMessage();
        }

        // Implement Unit test for rest of the sorting algorithms below
        int[] unSortedArray1 = {6, 9, 2, 5, 1, 0, 4};
        int[] sortedArray1 = {0, 1, 2, 4, 5, 6, 9};
        sort.insertionSort(unSortedArray1);
        try {
            Assert. assertEquals(sortedArray1, unSortedArray1, "ARRAY IS NOT SORTED Using Insertion Sort.. YET!\n***YOU GOT THIS!***");// Display message when error founds

        } catch (Exception ex) {
            ex.getMessage();
        }

        // Implement Unit test for rest of the Bubble Sort algorithms below
        int[] unSortedArray2 = {6, 9, 2, 5, 1, 0, 4};
        int[] sortedArray2 = {0, 1, 2, 4, 5, 6, 9};
        sort.insertionSort(unSortedArray2);
        try {
            Assert. assertEquals(sortedArray2, unSortedArray2, "ARRAY IS NOT SORTED Using Bubble Sort.. YET!\n***YOU GOT THIS!***");// Display message when error founds

        } catch (Exception ex) {
            ex.getMessage();
        }

    }
}
