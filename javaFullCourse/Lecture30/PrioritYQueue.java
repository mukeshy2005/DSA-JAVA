package javaFullCourse.Lecture30;
import java.util.PriorityQueue;
import java.util.Queue;
public class PrioritYQueue {
    public static void main(String [] args){
            Queue<Integer> qq = new PriorityQueue<>();
            /*priority are on the basis of who has low value*/
            qq.offer(10);
            qq.offer(20);
            qq.offer(30);
            qq.offer(40);
        System.out.println(qq);

        qq.poll();
        System.out.println(qq);

        qq.poll();
        System.out.println(qq);
    }
}
