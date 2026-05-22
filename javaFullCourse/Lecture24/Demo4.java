package javaFullCourse.Lecture24;

public class Demo4 {
    public static void main(String[] args) {
        Dog d = new StreetDog();
        d.eat();
    }
}
interface Animal {
    void eat();
}
interface Dog extends Animal {
    void bark();
}
class StreetDog implements Dog {
    /*since both method are inside interface streetdog is implementning dog which inher the animal
    * we need override both method belongs to animal and dog interface*/
    @Override
    public void eat() {
        System.out.println("eat");
    }
    @Override
    public void bark() {
        System.out.println("bark");
    }
}