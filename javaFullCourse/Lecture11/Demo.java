package javaFullCourse.Lecture11;

public class Demo {
    public static void main(String [] args) {
        // Functioon overloading in java
        // starting with the basic example 
        //  int i;
        // int j;
        // System.out.println(sum(5,6));

         for(int i = 1;i < 5;i++){
            greet();
        }
        sayHello("mukesh");
        int x = getNumber();
        System.out.println(x); // can also be written as System.out.pritnln(getNumber);
        System.out.println(multiply(5,6));
    }
    static int sum(int a, int b){
        int result = a+b;
        return result;
    }
     static void greet(){
        System.out.println("hello");
        return; // optional
    }
    // inut but no output type
    static void sayHello(String name ){// number of input parameter can be of anything
        System.out.println("hello "+name);
        return;
    }
    //no  input but output
    static int getNumber(){
        return 10;
    }
    //input or output
    static int multiply(int a , int b){
        int multi  = a*b; // can also be written as return (a*b)
        return multi;
    }
    
}
