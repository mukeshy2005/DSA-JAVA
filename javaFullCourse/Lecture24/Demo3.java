package javaFullCourse.Lecture24;
// multiple inheritance
public class Demo3 {
    public static void main(String[] args) {
        A a = new c();
        a.fun1();
    }
}
interface A {


    void fun1();
}
interface B {
    void fun2();
}
class c  implements A,B {
    @Override
    public void fun1() {
        System.out.println("fun");
    }
    @Override
    public void fun2() {
        System.out.println("fun2");
    }
}