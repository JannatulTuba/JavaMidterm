package math.problems;

public class FindMissingNumber {

    public static int Search(int arr[],int n){

        int sumArr = 0;
        int sumNumber = 0;

        // add all the array elements
        for(int i=0;i<arr.length;i++){
            sumArr += arr[i];
        }

        //add all the numbers from 1-n
        for(int j=1;j<=n;j++){
            sumNumber += j;
        }

return  sumNumber -  sumArr;
    }
    public static void main(String[] args) {
        /*
         If n = 10, then array will have 9 elements in the range from 1 to 10.
            For example {10, 2, 1, 4, 5, 3, 7, 8, 6}. One number will be missing in array (9 in this case).

         Write a method to find the missing number from the array.
         */
        int[] array = new int[] {10, 2, 1, 4, 5, 3, 7, 8, 6};
        System.out.println("Missing number "+ Search(array,10));
    }
}
