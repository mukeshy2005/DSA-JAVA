package javaFullCourse.Lecture19;
//Anonymous Class
public class Demo7 {
    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.introduce();
//
//        Person p2 = new Guest();
//        p2.introduce();
//
        Person p2 =  new Person(){// this is anonymous class it does not have class name
            @Override
            void introduce(){
                System.out.println("hi , i am guest");
            }
        };
        p2.introduce();
    }
}

class Person {
    void introduce() {
        System.out.println("Hi , I am person ");
    }
}

class Guest extends Person {
    @Override
    void introduce() {
        System.out.println("Hi , I am guest");
    }
}