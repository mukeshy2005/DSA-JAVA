package javaFullCourse.ExceptionHandling;

public class Demo5 {
    static void main() {
        int[] numbers  = {1,2,4,6,7};
        try{
            System.out.println(numbers[5]); // i will receive an exception
        }
        catch(Exception e){ // we can use Exception too incase we dont know the Exception name
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("this will always execute whether there is an exception or not ");
        }
    }
}
