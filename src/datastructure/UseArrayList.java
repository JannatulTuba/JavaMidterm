package datastructure;

import java.util.ArrayList;

public class UseArrayList {



    public static void main(String[] args) {
        /*
         * Demonstrate how to use ArrayList that includes using the add, peek, remove & retrieve methods.
         * Use For-Each loop and While-loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        ArrayList<String> student = new ArrayList<String>();

        //add elements in ArrayList
        student.add("Jhon");
        student.add("Deep");
        student.add("Saji");
        student.add("Arisha");
        student.add("Mim");
        System.out.println("Result Before removing :"  + student);


        //remove method
        student.remove( "Deep");
        System.out.println("Result after removing one element: "+student);

        //get method
        System.out.println("get method: "+ student.get(2));

        //for each loop
        System.out.println("***********For each loop result************");
        for(String name:student){
            System.out.println(name);

        }

        // while loop
        System.out.println("***********while loop result***************");
        int  len = student.size()-1;
        int i= 0;
        while (i<=len){
            System.out.println(student.get(i));
            i++;
        }

    }

}
