package javaFullCourse.Lecture24;

public class Demo2 {
    public static void main(String[] args) {
        MathConstant m = new Random();
        m.fun(); // will show an error if the method is not present inside the interface
    }
}
/*constant variable inside the interface*/
interface MathConstant{
    /*by default variable inside the interface is public static final variable value cannnot be change*/
    double PI = 3.14;
    void fun();
}
class Random implements MathConstant{
    @Override
    public void fun(){
        System.out.println(PI);
    }
}