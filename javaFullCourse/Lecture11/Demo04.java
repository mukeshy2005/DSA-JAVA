package javaFullCourse.Lecture11;

public class Demo04 {
    public static void main(String [] args){
        // recursion in java 
        //examle 1 
          printNum(5);
    }
      static void printNum(int n) {
        //base case
        if (n == 0) {
            return;
        }
        printNum(n-1);
        System.out.println(n);// printing number in order 12345
        
    }
}
