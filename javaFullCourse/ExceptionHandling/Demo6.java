package javaFullCourse.ExceptionHandling;

public class Demo6 {
    //Custom Exception Handling
    public static void main(String[] args) {
        int age = 17;
        getAge(age);
    }
    public static void getAge(int age){
        if(age < 18){
            throw new ArithmeticException("accesd denied");
        }
        else{
            System.out.println("access granted");
        }
    }
}
