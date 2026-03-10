package javaFullCourse.Lecture14;
// call by value
public class Main {

    static void doubleIt(int num) {
        num = num * 2;   // only changes the COPY
        System.out.println("Inside method: " + num);  // 20
    }

    public static void main(String[] args) {
        int x = 10;          // original value
        doubleIt(x);
        System.out.println("After method: " + x);  // still 10 !
    }
}