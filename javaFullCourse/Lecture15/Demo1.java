package javaFullCourse.Lecture15;

public class Demo1 {
    public static void main(String[] args) {
        // we will discuss final keyword here
        // it is used to make a variable constant
        System.out.println();
        Random r = new Random();
//        r.PI = 4;//java: cannot assign a value to final variable PI
        System.out.println(r.PI);

        //why main method is static in java
        // we have class Demo1 and a  main method
        // then we have to create an object Demo4  d1 = new Demo4;
        // and  calling the object d1.main
        // Demo4.main();
    }
}

class Random{
    final double PI ; // we cannot change the value PI varibale
    // final double PI = 3.14;
    Random(){
        PI = 3.14; // WE  can do this also
    }
    // generally variable name is taken as capital
}