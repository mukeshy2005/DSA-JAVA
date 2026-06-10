package javaFullCourse.Lecture26;

public class Demo7 {
    public static void main(String[] args) {
        Box5 <Fish> b = new Box5<>();// can only works with fish
    }
}
class Box5 <T extends Animal & Swimmable>{
    /*syntax is <T extends class & interface1, interface2*/
    // remove the implements condition to work with other
    T value;
}
class Animal {
    void display(){
        System.out.println("Animal is displayed");
    }
}
interface Swimmable{
    void swim();
}
class Dog extends Animal {

}
class Fish extends  Animal implements Swimmable{
/*since fish can swim he needs to override them method*/
    @Override
    public void swim(){
        System.out.println("Fish is swimmable");
    }
}
