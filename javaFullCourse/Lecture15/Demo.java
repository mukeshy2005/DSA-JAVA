package javaFullCourse.Lecture15;

public class Demo {
    public static void main(String[] args) {
        Student s1 = new Student("ADITIYA",20,102);
        Student s2 = new Student("mukesh",21,100);

//        Student.college = "DSEU";

        System.out.println(s1.name+" "+s1.age+" "+s1.rollNum+" "+Student.college);
        System.out.println(s2.name+" "+s2.age+" "+s2.rollNum+" "+Student.college);
    }
}
// creating a class Student
class Student {
    String name;
    int age;
    int rollNum;
    static String college ;

    // creating constructor
    Student(String name, int age, int rollNum) {
        this.name = name;
        this.age = age;
        this.rollNum = rollNum;
    }
    // static block
    static {
        college = "DSEU";
    }
}
