package javaFullCourse.ExceptionHandling;
//Multiple Exception Handling
public class Demo7 {
    static void main() {
        try {
            int[] number = {1, 4, 5, 7};

            System.out.println(number[4]);

        }

        catch(IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(10/0);
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

}
