package javaFullCourse.ExceptionHandling;

public class Demo1 {
    public static void main(String[] args) {

        System.out.println("step1");
        //Exception Handling
        try{
            int a = 5;
            int b = 0;

            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            System.out.println(" zero is not allowed in the denominator");
        }

        System.out.println("step2");
    }
}
