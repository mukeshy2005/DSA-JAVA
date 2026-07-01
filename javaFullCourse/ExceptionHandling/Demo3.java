package javaFullCourse.ExceptionHandling;

public class Demo3 {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        //ExceptionHandling in the code of Demo.java file
        methodA(5,0);
    }

    public static void methodA(int a, int b){
        try{
            methodB(a,b);
        }
        // we can do the same in the upper parent method that is main method
        catch(ArithmeticException e){
            System.out.println("Arithmetic Exception");
        }
    }
    public static void methodB(int a, int b){

            System.out.println(a/b);

//        catch(ArithmeticException e){
//            //currently the exception is handled in the methodB , i want to handle it at the parent method
//            System.out.println("Denominator zero is not allowed ");
//        }
    }
}
