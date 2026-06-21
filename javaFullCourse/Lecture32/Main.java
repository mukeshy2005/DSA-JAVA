package javaFullCourse.Lecture32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Main {
 public static void main (String [] args){

    List<Students> students = new ArrayList<>();
    students.add(new Students("mukesh",18,40));
    students.add( new Students("vishal",20,50));
    students.add( new Students("kalan",20,30));
    students.add( new Students("mohan",17,60));

     System.out.println(students);

     Collections.sort(students,new weightComparator());
     System.out.println(students);


//
//   List<Integer> list = new ArrayList<>();
//   list.add(1);
//   list.add(10);
//   list.add(92);
//   list.add(2);
//
//   //store in the order as specified
//     System.out.println(list);
//
//     // to sort
//   Collections.sort(list);
//     System.out.println(list);
}
}
