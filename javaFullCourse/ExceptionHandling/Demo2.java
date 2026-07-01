package javaFullCourse.ExceptionHandling;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int a = 5;
        int b = 5;
        //ExceptionHandling in the code of Demo.java file
        methodA(5,2);
    }

    public static void methodA(int a, int b){
        methodB(a,b);
    }
    public static void methodB(int a, int b){
        try{
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            //currently the exception is handled in the methodB , i want to handle it at the parent method
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
        finally{
            // this always run even if exception comes or not
            System.out.println("finally block");
        }
        System.out.println("Hello World");
    }

}
