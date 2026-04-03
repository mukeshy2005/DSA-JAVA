package javaFullCourse.Lecture20;
import java.util.Scanner;
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // we need to give the argument because internally it using input stream
        String name = sc.nextLine();
        System.out.println("Hello " + name);
    }
}
