package javaFullCourse.Lecture18;

public class Demo2 {
    public static void main(String[] args) {
//        // this is autoboxing
//       int x = 10;
////       Integer y = x;
//       Integer y = new Integer(x);
//
//       System.out.println(x);
//       System.out.println(y);
//       // unboxing
//        Integer a = Integer.valueOf(20);
////       Integer a = new Integer(12);
//       int b =  a;
//       System.out.println(a);
//       System.out.println(b);

//       Integer x  = 50;
//       printInteger(x);
//
//       Integer a = 18;
//       Integer b= 12;
//       int sum = a.intValue() + b.intValue();
//       System.out.println(sum);

        Integer x = null;
        int y = x; // this will give an error we can assign the null value to a method
        // will show an error at the compile time
        System.out.println(y);

    }
    //creating a printmethod
    static void printInteger(int x){
        System.out.println(x);
    }
    
}
// the value of unboxing and autoboxing is applicable in
//1. Assignments
//2 Method calls
//3. Arithmetic