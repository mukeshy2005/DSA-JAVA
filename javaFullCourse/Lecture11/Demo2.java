package javaFullCourse.Lecture11;

public class Demo2 {
    // fucnction overloading
    public static void main(String [] args) {
        System.out.println(sum(5,6));
         System.out.println(sum(5,6,8));
           System.out.println(sum(393393,8299232));
             greet("mukes",59);
              greet(58,"mukesh");
}
static int sum(int a, int b) {
        return a+b;
    }
    static int sum(int a, int b, int c) {
        return a+b+c;
    }
    static double sum (double a , double b) {
        return (int) (a+b);
    }
    static void greet (String name , int age ) {
        System.out.println("hello "+name+" your age "+age);
    }
    static void greet (int age, String name ) {
        System.out.println("hello "+name+" your age "+age);
    }
    
} 
