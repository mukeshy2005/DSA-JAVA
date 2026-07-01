package javaFullCourse.Lecture24;
/* declration of method inside interface*/
/*Defualt method */
public class Demo5 {
    public static void main(String[] args) {
        Vehicle v = new Car1();
        v.drive();
        Vehicle.brake();
    }
}
/*After java 8 -->> default method , static method
* Aftr java 9 --> private methdo / access modifier*/
interface Vehicle{
    default void drive(){
        System.out.println("drive");
    }/*by default the method inside interface is public abstract*/
    static void brake(){
        System.out.println("brake applied");
    }
    private void accelerate(){
        System.out.println("accelerate applied");
    }
}
class Car1 implements Vehicle{
    @Override
    public void drive() {
        System.out.println("drive  car");
    }
}
