package javaFullCourse.Lecture22;
// Topic = Oject classes
public class Demo {
    public static void main(String[] args) {
       Student s1 = new Student();
       s1.name = "mukesh";
       s1.age = 21;
//       System.out.println(s1.name);
//       System.out.println(s1.age);
       System.out.println(s1.toString());// will print Student@5caf905d
    }
}
class Student{// This student class inhertes the Object class
    String name;
    int age;
    // will Override the method toString
    @Override
    public String toString(){
        return (name+" , "+age);
    }
}