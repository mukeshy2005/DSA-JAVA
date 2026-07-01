package javaFullCourse.JavaStreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String []args){
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(12);
        list.add(7);
        list.add(1);

        Collections.sort(list);
        System.out.println(list);
    }
}
