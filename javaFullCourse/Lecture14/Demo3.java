package javaFullCourse.Lecture14;

class Dog {
    String name;
    Dog(String name) { this.name = name; }
}

public class Demo3 {

    static void rename(Dog d) {
        d.name = "Bruno";   // modifies the REAL object
    }

    public static void main(String[] args) {
        Dog myDog = new Dog("Max");
        System.out.println(myDog.name);   // Max
        rename(myDog);
        System.out.println(myDog.name);   // Bruno ← changed!
    }
}