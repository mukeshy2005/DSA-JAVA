package javaFullCourse.Lecture11;

public class Demo05 {
    public static void main(String [] args ) {
         fib(5);
        int result = fib(5);
    }
    static int fib(int n) {
        if (n == 0) return 0;   // fib(0) = 0
if (n == 1) return 1; 
      int x = fib(n-1);
      int y = fib(n-2);
      return x+y;
      
    }
}
