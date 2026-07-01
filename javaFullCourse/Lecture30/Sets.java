package javaFullCourse.Lecture30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        System.out.println(set);

        set.remove(10);
        System.out.println(set);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(20);
        arr.add(10);
        arr.add(60);
        set.addAll(arr);
        System.out.println(set );

        Set<Integer> set2 = new HashSet<>();
        set2.add(10);
        set2.add(20);
        set2.add(30);
        set2.add(40);

        Set set3 = new TreeSet<>();
        set3.add(30);
        set3.add(40);
        set3.add(50);
        set3.add(60);
        set3.add(10);
        set3.add(20);

        /*retainAll method*/
        set2.retainAll(set3);
        System.out.println(set2);

        System.out.println(set2.containsAll(set3));
        System.out.println(set3.containsAll(set2));

    }
}
