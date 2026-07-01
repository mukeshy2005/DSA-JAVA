package javaFullCourse.ExceptionHandling;

public class Demo4 {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        //ExceptionHandling in the code of Demo.java file
        try{
            methodA(5,0);
        }
        catch(ArithmeticException e){
            System.out.println("Arithmetic Exception is occured");
        }

    }

    public static void methodA(int a, int b){
        methodB(a,b);
    }
    public static void methodB(int a, int b){

            System.out.println(a/b);


    }
}
