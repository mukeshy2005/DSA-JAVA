package javaFullCourse.ExceptionHandling;

public class Demo8 {
    public static void main(String[] args) {
        try{
            System.out.println(10/0);
            int [] number = {1,3,4,4,};
            System.out.println(number[4]);
        }
        catch(ArithmeticException | NullPointerException e) {
            System.out.println("math error and nullpointer error");
        }
    }
}
