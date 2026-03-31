//package javaFullCourse.Lecture19;
//// Topic ---> Nested Class
////Types = 1.Static nested 2.inner class  3.local class  4.anonymous class
//public class Demo1 {
//    public static void main(String[] args) {
//        //creating object of outer class
//        Outer outer = new Outer();
//        // to access the inner class
//
//        Outer.Inner inner = new Outer.Inner(outer);
//        inner.PrintHello();
//    }
//}
////class Outer {
////    static int a = 10;// can acces onyl static variable
////    int b = 10; // How to acces this int b
////    static class Inner  extends Demo1{ // inner class can extend outer class also
////        Outer outer;
////        Inner(Outer outer){
////            this.outer = outer;
////        }
////        //creating a method
////        void PrintHello(){ // refe rence is passed
////            System.out.println("!Hola Amigo!");
////            System.out.println(a);
////            System.out.println(outer.b);// will show an error
////        }
////
////    }
////}
//class BankAccount{
//    static class InterestCalculator{
//        static double calculateYearly(double principal, double rate){
//            return principal*rate;
//        }
//    }
//    public double computeInterest(double principal){
//        return InterestCalculator.calculateYearly(principal, 1.5);
//    }
//}