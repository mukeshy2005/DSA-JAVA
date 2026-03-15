public class Demo{
    public static void main(String[] args){
        // Car c = new FuelCar();
        Car c = new ElectricCar();
        c.start();
        c.accelerate();
        c.brake();
    }

}
abstract class Car {
    void start(){
        System.out.println("car is starting");
    }
    abstract void accelerate();
    abstract void brake();
}

class FuelCar extends Car {
    // void start(){
    //     // System.out.println("Fuel car is starting");
    // }
    void accelerate(){
        System.out.println("Fuel car is accelerating");
    }
    void brake(){
        System.out.println("Brake is applied on fuel car");
    }
}

class ElectricCar extends Car {
    void accelerate(){
        System.out.println("Electric car is accelerating");
    }
    void brake(){
        System.out.println("Brake is applied on Electric  car");
    }
}