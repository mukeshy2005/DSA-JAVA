package javaFullCourse.Lecture13;

public class Demo2 {
    public static void main(String[] args) {
        // studying constructor and overloading of constructor
        Student s1 = new Student(); // this is an object
        System.out.println(s1.name); // output will be default values
        System.out.println(s1.rollNum);
        System.out.println(s1.college);

        Student s2 = new Student();
    }
    static  class Student {
        String name;
        int age;
        int rollNum;
        String college;

        // Default constructor
        Student(){
            String name;
            int age;
            int rollNum;
            String college;
        }

        // parameterized constructor " just like we uses in functions

        Student(String n ,int rn,String c){
            name = n;
            rollNum = rn;
            college = c;
        }
    }




}
