package algorithm;

public class Sort {

    long executionTime = 0;
    /*
     * Please implement all the sorting algorithm. Feel free to add helper methods.
     * Store all the sorted data into one of the databases.
     */

    public static void printSortedArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
/*******************************************************************************************************************/
    public int[] selectionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;

        for (int j = 0; j < array.length - 1; j++) {
            int min = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
/*******************************************************************************************************************/
    public int[] insertionSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        int min,temp,j;

        for (int i = 1; i < array.length; i++) {
            min = list[i];
            j=i-1;
            while (j>=0 && min<list[j]){
                temp = list[j];
                list[j]=list[j+1];
                list[j+1] = temp;
                j--;
            }

            }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

            return list;
        }

    /***************************************************************************************************************************************
    Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order
  ******************************************************************************************************************************************/
    public int[] bubbleSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        int n = array.length;

        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)

                // Check if arr[j] > arr[j+1]  which means left element is greater or not
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    /*******************************************************************************************************************/


    public int[] mergeSort(int[] array) {
        final long startTime = System.currentTimeMillis();

       int[] list = array;
        //implement here



        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    /*******************************************************************************************************************/

    public int[] quickSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int[] list = array;
        //implement here

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    /*******************************************************************************************************************/

    public int[] heapSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int[] list = array;
        //implement here

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    /*******************************************************************************************************************/

    public int[] bucketSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    /*******************************************************************************************************************/

    public int[] shellSort(int[] array) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        //implement here
        int n = array.length;

//        for (int gap = n/2; gap > 0; gap /= 2)
//        {
//            for (int i = gap; i < n; i += 1)
//            {
//                int temp = array[i];
//
//                int j;
//                for (j = i; j >= gap && array[j - gap] > temp; j -= gap){
//                    array[j] = array[j - gap];
//                }
//                array[j] = temp;
//                }
//
//
//            }


        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
}
