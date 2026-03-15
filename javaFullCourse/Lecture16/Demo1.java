package javaFullCourse.Lecture16;
// inheritance
public class Demo1 {
    public static void main(String[] args){
        EngineeringStudent es = new  EngineeringStudent();
        es.markAttendance();
        es.attendLab();

        //making another object to test can we call Engineering student method from student
        Student sc = new Student();
        sc.markAttendance();
//        sc.attendlab(); //showing error
    }
}
// Student is parent class (super class )
//public class Student {
//    String name;
//    int rollNum;
//
//    void markAttendance(){
//        System.out.println("Marking attendance");
//    }
//}
//
//// child class
//public class EngineeringStudent extends Student{
//    void attendLab(){
//        System.out.println("Attending Lab");
//    }
//}
