package javaFullCourse.Lecture26;

public class Demo4 {
    public static void main(String[] args) {
        Integer y = getSum(10);
        System.out.println(y);
        /* below concept is called type inference*/
        pair(10,10);
        pair("hello",10);
    }
    public static <T> T getSum(T str){
        return str ;
    }

    public static <T,U> void pair(T fisrt, U second){
        System.out.println(fisrt+" , "+  second);
    }
//    public static Object getSum(Object a){
//        return a;
//    }
}
