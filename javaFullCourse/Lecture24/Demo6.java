package javaFullCourse.Lecture24;

public class Demo6 {
    public static void main(String[] args) {
        X x = new X();
        x.fun();
    }
}
interface K {
    void fun();
}
interface J extends K {
    default void fun(){
        System.out.println("print J");
    }
}
interface Z extends K{
    default void fun(){
        System.out.println("print Z");
    }
}
class X implements Z,J{
    @Override
    public void fun() {
        // agr main yaha chahta hoon ki z interface ka method call ho . to hum super keyword use kar sakte hai
        Z.super.fun();
        J.super.fun();
    }
}