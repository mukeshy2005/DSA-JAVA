package javaFullCourse.Lecture11;

public class Demo03 {
    public static void main(String [] args) {
        // chaining of function
         fun1();
        System.out.println("bye");
    }
     static void fun1() {
        fun2();
        System.out.println("hi");
    }
    static void fun2(){
        fun3();
        System.out.println("how are you ");
    }
    static void fun3(){
        System.out.println("hola como estas");
    }
}
