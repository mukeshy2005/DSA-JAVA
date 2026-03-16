package javaFullCourse.Lecture17;
// interface ( high level abstraction)
public class Demo2 {
    public static void main(String[] args) {
        car c = new FuelCar();
        c.start();
        c.accelerate();
        c.start();
        c.accelerate();
    }
}

interface car{ // we have used the interface keyword no need to use class here
    void start();
    void accelerate();
    void brake();
}

class FuelCar implements car{ // implement keyword instead of  extends keyword when using interface
    @Override
    public void start(){ // we need to make method public other it will be default type acces modifier
        System.out.println("Fuel car is started");
    }
    @Override
    public void accelerate() {
        System.out.println("Fuel car is accelerating");
    }
    @Override
    public void brake() {
        System.out.println("Fuel car is braking");
    }
}
class ElectricCar implements car{
    @Override
    public void start(){
        System.out.println("Electric car is started");
    }
    @Override
    public void accelerate() {
        System.out.println("Electric car is accelerating");
    }
    @Override
    public void brake() {
        System.out.println("Electric car is braking");
    }
}