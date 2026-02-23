

public class Tesla {
    String color;
    int batteryLevel;

    void drive() {
        System.out.println("The car is moving!");
    }
}

// 2. THE TEST TRACK (The Main Class)
// This is where the action happens.
class FactoryTester {
    public static void main(String[] args) {

        // Step A: Manufacture the car
        Tesla car1 = new Tesla();

        // Step B: Paint it (Set State)
        car1.color = "Red";

        // Step C: Test it (Call Method)
        car1.drive();

        // Let's make a SECOND car from the same blueprint!
        Tesla car2 = new Tesla();
        car2.color = "Blue"; // This one is blue
    }
}
