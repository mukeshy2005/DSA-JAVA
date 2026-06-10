package javaFullCourse.Lecture26;

public class Demo6 {
    public static void main(String[] args) {
        House <Integer> h = new  House <>();
        h.value = 10;
        h.printDouble();
    }
}
/*Bounds in Generics
* Upper Bounds
*Generics -->  T can be anything*/
class House <T extends Number>{
    T value;

    public void printDouble(){
        System.out.println(value.doubleValue());
    }
}