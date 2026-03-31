package javaFullCourse.Lecture19;

public class Demo5 {
    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        Outer2.Inner2 inner = outer.new Inner2();
        inner.printm();
        Outer2.Inner2.sayHello();
        inner.sayHello();

    }
}
class Outer2{
    static int x = 10;
    int y = 20;
    class Inner2{
        int x = 20;
        void printm(){
            System.out.println(x);
            System.out.println(Outer2.this.x); // to access the variable x of outer class
//            System.out.println(y);
        }
        static void  sayHello(){
            System.out.println("hello");
        }

    }
}