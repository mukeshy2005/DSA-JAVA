package javaFullCourse.Lecture13;

public class Demo3 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("mohit");
        Student s3 = new Student("mohit",20);
        Student s4 = new Student("mohit",20,42);
        Student s5 = new Student("mohit",20,42,"DSEU");

        System.out.println(s4.college);
    }
    // creating student class
    static class Student{
        String name ;
        int rollNum ;
        int age ;
        String college ;

        // creating a default constructor
        // this is constructor chaining if you call any constructor we get value of forth one
        Student(){
         // even in the default constructor we can give default value
            this("unknown",0,0,"unknown");;
        }
        // below we have overloading of constructor with same name but different parameter
        // creating a constructor with one parameter
        Student(String name){
            this(name,0,0,"unknown");;
//            this.name=name;

        }
        //constructor with two parameter
        Student(String name , int rollNum){
            this(name,rollNum,0,"unknown");
//            this.name = name;
//            this.rollNum = rollNum;
        }
        //constructor with three parameter
        Student(String name , int rollNum, int age ){
            this(name,rollNum,age,"unknown");
//            this.name = name;
//            this.rollNum = rollNum;
//            this.age = age;
        }
        //constructor with four parameter
        Student(String name , int rollNum, int age, String college ) {
//
            this.name = name;
            this.rollNum = rollNum;
            this.age = age;
            this.college = college;
        }
    }

}
