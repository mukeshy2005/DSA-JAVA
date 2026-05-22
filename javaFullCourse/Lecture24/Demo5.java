package javaFullCourse.Lecture24;
/* declration of method inside interface*/
/*Defualt method */
public class Demo5 {
    public static void main(String[] args) {
        Vehicle v = new Car1();
        v.drive();
    }
}
interface Vehicle{
    default void drive(){
        System.out.println("drive");
    }/*by default the method inside interface is public abstract*/
}
class Car1 implements Vehicle{
    @Override
    public void drive() {
        System.out.println("drive  car");
    }
}
