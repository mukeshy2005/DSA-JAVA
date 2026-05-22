package javaFullCourse.Lecture24;

public class Demo {
    public static void main(String[] args) {
        Car c = new thar2();
        c.drive();
    }
}
interface Car{ // not a class it is an interface
    public void drive(); // no need to define
}
abstract class thar implements Car{
    @Override
    abstract public void drive();
}
class thar2 extends thar{
    @Override
    public void drive() {
        System.out.println("driving thar2");
    }
}
/*
* if a class does not want to override the method implemenetd from a interface then he need to have to use abstact method */
/*
* abstract class thar implements Car{
    @Override
    abstract public void drive();
}*/

// i want to uderstand the difference between abstact class and interface when an abstact class is used or when interfece used
