package javaFullCourse.Lecture30;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
public class PrioritYQueue {
    public static void main(String [] args){
            Queue<Integer> qq = new PriorityQueue<>();
            /* defalut behaviour priority are on the basis of who has low value*/
            qq.offer(10);
            qq.offer(20);
            qq.offer(30);
            qq.offer(40);
        System.out.println(qq);

        qq.poll();
        System.out.println(qq);

        qq.poll();
        System.out.println(qq);
        /*we can change the default behaviour using comparator
        * using lamda fucntion will study in next class*/
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(10);
        System.out.println(list);
    }
}
