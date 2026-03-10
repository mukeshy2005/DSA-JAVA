package javaFullCourse.Lecture15;

public class Demo1 {
    public static void main(String[] args) {
        // we will discuss final keyword here
        // it is used to make a variable constant
        System.out.println();
        Random r = new Random();
//        r.PI = 4;//java: cannot assign a value to final variable PI
        System.out.println(r.PI);
    }
}

class Random{
    final double PI = 3.14; // we cannot change the value PI varibale
    // generally variable name is taken as capital
}