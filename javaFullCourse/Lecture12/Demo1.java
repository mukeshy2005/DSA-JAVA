package javaFullCourse.Lecture12;

public class Demo1 {
    public static void main(String [] args) {
        // introduction to OOPS in java
         Dog d1 = new Dog();
        d1.type = "labra";
        d1.name = " dolly";
        d1.age = 5;
        
        // another dog
        Dog d2 = new Dog();
        d2.type = " bully";
        d2.name = "muku";
        d2.age = 3;
        
        d1.Bark();
        System.out.println(d1.type);
        System.out.println(d2.type);
        System.out.println(d2.name);
             
    }
    static class Dog{
        String type;// instance variable which define the characteristics of an object
        String name;
        int age;
        
        void Bark(){//  Function or behaviour represent object
            System.out.println("bow bow"); 
        }
    }
}
