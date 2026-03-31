package javaFullCourse.Lecture19;

public class Demo6 {
    public static void main(String[] args) {
        Outer4 o = new Outer4 ();
        o.fun();
    }
}
class Outer4{
    void fun(){
        class Local{
            void sayHello(){
                System.out.println("hello");
            }
        }
        Local local = new Local();
        local.sayHello();
    }
}