package javaFullCourse.Lecture19;

public class Demo3 {
    public static void main(String[] args) {


    Outer.Inner inner = new Outer.Inner();
    Outer outer = new Outer();
        inner.printNum(outer);
    }
}
class Outer{
    static int x = 10;
    int y = 3;
    static class Inner{

        static void printNum(Outer outer){
            System.out.println(x);
            System.out.println(outer.y);
            // there are two was to acces non static variale one though passsing reference
            // another through constructor

        }

    }
}
