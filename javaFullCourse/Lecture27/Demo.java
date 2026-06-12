package javaFullCourse.Lecture27;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Demo {
    public static void main(String[] args) {
        /*Invariant in generics*/
//        List<Dog> dog = new ArrayList<Dog>();
//        List<Animal> animals = dog;
        // above is not allowed in java
        Dog[] dog = new Dog[10];
        Animal[] animals = dog;
        animals[0] = new Dog();
        animals[1] = new Dog();
        animals[2] = new Dog();
        animals[3] = new Animal();
        for( Animal animal : animals){
            if(animal == null){
                continue;
            }
           animal.eat();

        }
    }
}
class Animal{
    public void eat(){
        System.out.println("animal  is eating ");
    }
    public void walking(){
        System.out.println("animal  is walking ");
    }
}
class Dog extends Animal{
    public void bark(){
        System.out.println("Dog is barking ");
    }
}