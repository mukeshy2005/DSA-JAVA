package javaFullCourse.Lecture22;

public class Demo3 {
    public static void main(String []args){
    Student4 s1 = new Student4();
    Animal a = new Animal();
    Animal d = new Dog();

        System.out.println(a.getClass().getSimpleName());//this will return class animal due runtime usage of animal class
        System.out.println(d.getClass().getSimpleName());// this will return dog class due runtime use of dog class

        System.out.println(d instanceof Animal);// both will return true bacause d is object of subclass of Animal class
        System.out.println(d instanceof Dog);
    //notes .class also  tell us on runtime which class is used
    System.out.println(s1.getClass().getSimpleName()); // gives us the name of the class to which s1 is object
        System.out.println(s1 instanceof Student4); // will return ture as s1 is object of student class
        System.out.println(s1 instanceof Object); // this will also return true as s1 is object of subclass of Object class
    }
}
class Student4{

}
class Animal{

}
class Dog extends Animal{

}