package javaFullCourse.Lecture29;

import java.util.*;
import java.util.ArrayList;



// lecture by love bubber
public class Main {
    public static void main (String [] args){
        // we can create a dynamic array using three ways
        //Arraylist is concrete class
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 1;i<=20;i++){
            arr.add(i);
        }
        System.out.println(arr);
        arr.remove(0);
        System.out.println(arr);
        System.out.println(arr.size());
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i = 21;i<=25;i++){
            arr2.add(i);
        }
        arr2.add(20);
        arr.addAll(arr2);
        System.out.println(arr);
        arr.removeAll(arr2);
        System.out.println(arr);

        Iterator<Integer> iterator = arr.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


      List<Integer> list = new ArrayList<>(); //List implement collection
//
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list.get(0));
        list.set(0,40);
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        System.out.println(list2);

        list2.toArray();
        System.out.println(list2);
        System.out.println(list2.contains("b"));

        ArrayList<Integer> arr3 = new ArrayList<>(); // are interface
        arr3.add(20);
        arr3.add(10);
        arr3.add(30);

        //sorting the collection
        Collections.sort(arr3);
        System.out.println(arr3);
        Collections.sort(arr3,Collections.reverseOrder());
        System.out.println(arr3);
        // only shallow copy is made
        ArrayList<Integer> arr4 = (ArrayList<Integer>) arr3.clone();
        System.out.println(arr4);
        arr4.add(20);
        System.out.println(arr4);
        System.out.println(arr4.indexOf(20));


        //linkedList testing all the operation
        List <Integer> list3 = new LinkedList<>();
        list3.add(20);
        list3.add(30);
        list3.add(40);
        System.out.println(list3);
//        list3.remove(0);
//        System.out.println(list3.indexOf(20));
//        list3.indexOf(20);
//      list3.remove(Integer.valueOf(30));
//        System.out.println(list3);
//        list3.removeFirst();
//        System.out.println(list3);
//        list3.removeLast();
//        System.out.println(list3);
//
        ((LinkedList<Integer>) list3).offer(10);
        System.out.println(list3);

Vector<Integer> vector = new Vector<>();
vector.add(20);
vector.add(30);
vector.add(40);   }
}
