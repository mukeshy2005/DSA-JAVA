package javaFullCourse.Lecture18;

public class Demo4 {
    public static void main(String[] args){
//       Animal a = new Animal(); // abstract classes can not be directly initialized
        Animal a = new Dog("Bruno");
        a.makeSound();
    }
}
abstract class Animal{
    String name ;
    Animal(String name){
        this.name = name;
    }
    abstract void makeSound();
    void sleep(){
        System.out.println("I'm a sleep.");
    }
}
class Dog extends Animal{
    Dog(String name){
        super(name);
    }
    @Override
    void makeSound() {
        System.out.println("I'm a dog.");
    }
}
//abstract classes can not be initialized directly
// can contain abstract method (method without implementation
// can aslo contain normal method
// it meant to be extended


// questions
// can abstract classes have construcotr --> yes
//can abstract classes can be final --> is not allowed
// can abstract classes can have static method ---> yes
// private methods are allowed --> private methods are allowed but only in non abstract
//can asbtarct claases have final method ---> yes
//can asbtrcat claases have no abstract mthodd -- yes
