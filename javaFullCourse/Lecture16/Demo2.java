package javaFullCourse.Lecture16;
// Type of inheritance
// Simple inheritance
// multi-level inheritance
//hierarchical inheritance
//multiple inheritance ( not supported in java )
public class Demo2 {
    public static void main(String[] args) {}
}

// parent class
class Student {
    String name;
    int rollNum;

    void markAttendance(){
        System.out.println("Marking attendance");
    }
}

// child class
class EngineeringStudent extends Student{ // child class
    void attendLab(){
        System.out.println("Attending Lab");
    }
}

//class CSEngineeringStudent extends EngineeringStudent{

// multilevel inheritance
//    void Festival(){
//        System.out.println("Festival");
//    }
//}

class MedicalStudent extends Student{
    // it also has property of parent student
    void attendMedical(){
        System.out.println("Attending Medical");
    }
}

/*

// multilevel inheritance
* Student -- > EngineeringStudent --- > CSEngineeringstudent
*/

/*  multi level inheritance
* A---> B ---> C
* A is parent of B and B is parent of C*/

/*   A
   /   \
  B     C
 Hierarchical
  A is a parent and both B and C is child
 */


/*
multiple inheritance means A and  B  class become parent of class C
   A     B ( A and B are parent )
    \   /
      C ( C is a child )
 */