package javaFullCourse.FunctionalInterface;

public class Demo {
    static void main() {

    }
    //Creating a functional interface which has only one abstract method can have multiple statc or default method
    interface A{
        void greet();
        default void meet(){
            System.out.println("hello riya");
        }
        static void bye(){
            System.out.println("bye bye ");
        }
    }
}
