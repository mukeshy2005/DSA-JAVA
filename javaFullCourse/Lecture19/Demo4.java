package javaFullCourse.Lecture19;

public class Demo4 {
    public static void main(String[] args) {
//        Outer1 outer = new Outer1();// object of outer class
        // to create an object of inner class we will use object of outer class
//        Outer1.Inner1 inner = outer.new Inner1 ();
        // there is one more method to create object of  inner class
        Outer1.Inner1 inner = new Outer1().new Inner1();
        inner.sayHello();

    }
}
class Outer1{
    class Inner1{
        void sayHello(){
            System.out.println("hello");
        }
    }
}