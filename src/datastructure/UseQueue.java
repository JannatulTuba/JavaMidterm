package datastructure;

import algorithm.Sort;

import java.util.*;

public class UseQueue {
    private static void  ForEach(  Queue<String> names){

        System.out.println("****** For Each Loop*********");

        for(String  name: names){
            System.out.println(name);
        }



    }

    private static void  WhileLoop( Queue<String> names){

        System.out.println("******While Loop*********");

        // using Iterator to iterate through a queue
        Iterator<String> itr = names.iterator();

        // hasNext() returns true if the queue has more elements
        while (itr.hasNext())
        {
            // next() returns the next element in the iteration
            System.out.println(itr.next());
        }


    }
    public static void main(String[] args) {
        /*
         * Demonstrate how to use Queue that includes add, peek, remove & poll elements.
         * Use For-Each loop and While-Loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        Queue<String> names = new PriorityQueue<>();

        // Add string to end of Queue
        names.add("Tuba");
        names.add("Tanjia");
        names.add("Jerry");
        names.add("Harry");
        names.add("Mim");


        System.out.println(names);
        System.out.println("Peek: "+names.peek());//retrieves, but does not remove, the head of this queue, or returns null if this queue is empty
        System.out.println("******After removing one item********");
        System.out.println("Remove: "+names.remove());//retrieves and removes the head of this queue.
        System.out.println(names);
        System.out.println("******After polling item******** \n"+names.poll()); // print head and deletes the head
        System.out.println(names);

        WhileLoop(names);
        ForEach(names);
    }

}
