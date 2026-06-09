package javaFullCourse.Lecture26;
/*Generics*/
public class Demo2 {
    public static void main(String [] args){
        Box <Integer> b = new Box <Integer>(10); //type argument
        System.out.println(b.getValue()+5);// this was not possible in the object class
        Box<String> b1 = new Box <String>("hello");
        Box<Boolean> b2 = new Box<Boolean>(true);
        System.out.println(b2.getValue());
        System.out.println(b1.getValue());
    }
}
class Box <T>{//type parameter
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
/*type information is not lost*/