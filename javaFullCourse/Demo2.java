package javaFullCourse;
public class Demo2 {
    public static void main(String[] args) {
        // Relational operator in java , --> ==,!=, > ,< <=, >=
        int a = 5;
        int b = 10;
        boolean c = (a==b);
        System.out.println(c);// false 

        boolean  d = (a!=b);
        System.out.println(d);// true

        boolean e = (a>b);
        System.out.println(e);// false

        boolean f = (a<b);
        System.out.println(f);// true
        boolean g = (a<=b);// any one of the condition is true then it will return true
        System.out.println(g);// true
    }
}