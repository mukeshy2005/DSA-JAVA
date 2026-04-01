package javaFullCourse.Lecture19;

public class Demo6 {
    public static void main(String[] args) {
        Outer4 o = new Outer4 ();
        o.fun();
    }
}
class Outer4{
    private int x = 19; // instance variable
    static int y = 10;
    void fun(){
        // making a local variable
        int a = 13;
        a++; // we cannot modify it it is effectively final
        class Local{
            void sayHello(){
                System.out.println("hello");
                System.out.println(x);
                System.out.println(y);
                System.out.println(a); //error of effective final variable
            }
        }
        Local local = new Local();
        local.sayHello();
    }
}