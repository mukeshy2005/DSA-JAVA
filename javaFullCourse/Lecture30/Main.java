package javaFullCourse.Lecture30;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        /*this is was for insertion of element instead of add to avoid exception handling*/
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        System.out.println(queue);

        /*using poll() instead of removal() to again avoid exeption handling*/
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);

//        queue.peek();
        System.out.println(queue.peek());

    }
}
