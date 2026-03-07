package javaFullCourse.Lecture13;

public class Demo1 {
    public static void main(String [] args) {
         Student s1 = new  Student();
         s1.name = "mukesh";
         s1.age = 20;
         s1.rollNum = 42;
         s1.college = "DSRU";
        // if value are not given to instance variable that they store default vaues 
        // tht is 
        /* int = 0
        boolean = false
        String = null
        float = 0.0*/
         
        System.out.println(s1.name);
         System.out.println(s1.rollNum);
    }
    
    static class Student{
        String name;
        int age ;
        int rollNum;
        String college;
        
        void markAttendance(){
            System.out.println(name+" is present");
        }
    }
}
