package datastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Stack;

public class DataReader {

    static FileReader fileReader;
    static BufferedReader bufferedReader;

    public  static void ReadFile(String path){

        String data = "";

        String[] words = new String[200] ;

        //Stack myStack
        Stack<String> myStack = new Stack<>();
        LinkedList<String> myLinkedList = new LinkedList<String>();

        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);

            try {
                while ((data = bufferedReader.readLine()) != null) {

                    System.out.println(data);

                    words = data.split(" ");

                    for(int i=0; i<words.length; i++){
                        myStack.push(words[i]);
                        myLinkedList.add(words[i]);
                    }
                }
                System.out.println(myStack);
                System.out.println(myLinkedList);
                System.out.println("\nDone reading file\n");

            } catch (Exception e1) {
                System.out.println("UNABLE TO READ LINE");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("FILE NOT FOUND AT " + path);

        } catch (Exception ex) {
            System.out.println("UNABLE TO OPEN BUFFERED READER ON FILE AT PATH: " + path);

        } finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println("UNABLE TO CLOSE BUFFERED READER");
            }
            System.out.println("*******Reading word from Stack Starts***********");
            PrintStack(myStack);
            System.out.println("*******Reading word from Stack ends***********");
            LinkedList(myLinkedList);
        }
    }
    static void PrintStack(Stack<String> s){

        //checks if the stack is empty
        if(s.empty()){
            return;
        }
        String x =s.peek();

        System.out.println(s.pop()); // pop the top element of stack and store it in Line


        // Recursively call the function PrintStack
        PrintStack(s);

        // Push the same element onto the stack to preserve the order
         s.push(x);

    }

    static void LinkedList(LinkedList<String> ll){
        // Using the Get method and the
        // for loop
        for (int i = 0; i < ll.size(); i++) {

            System.out.println(ll.getLast() + " ");
            ll.removeLast();
        }



    }


    public static void main(String[] args) {
        /*
         * Create an API to read the below textFile and print it to the console.
         *      HINT: Use BufferedReader class
         * Use try-catch block to handle Exceptions
         *
         * Store and retrieve the file to/from a database table.
         *
         * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
         * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
         * order from LinkedList and retrieve as FILO order from Stack.
         *
         * Demonstrate how to use Stack using push, peek, search & pop methods.
         * Use For-Each & While-loop with Iterator to retrieve data.
         */

        String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car";
        ReadFile(textFile);
    }

}
