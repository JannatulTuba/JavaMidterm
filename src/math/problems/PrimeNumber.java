package math.problems;

public class PrimeNumber {

    public  static void PrimeNumber(int num){

        boolean isPrime = true;

        for (int i = 2 ; i<=num ; i++){

                isPrime = true;

                for(int j = 2; j<i ;j++){
                    if(i % j == 0){
                        isPrime = false;
                        break;
                    }

                }
                if(isPrime ){
                    System.out.print(i+ " ");
                }


        }
    }


    public static void main(String[] args) {
        /*
        Write a method to print the list of prime numbers from 2 to 1,000,000
            Solving the problem should be your first priority, however bonus points if you can figure out how to
            improve algorithmic efficiency

         Print out the prime numbers in the given range.
         */

        PrimeNumber(1000000);
    }

}
