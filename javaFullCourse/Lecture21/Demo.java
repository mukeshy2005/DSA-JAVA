package javaFullCourse.Lecture21;
// Topic-->immutable classes
public class Demo {
    public static void main(String[] args) {
        College college = new College("DSEU", "Delhi");
       Student s1 = new Student(21,"mukesh", college);
//       System.out.println(s1.getName());
//        System.out.println(s1.getAge());
//        System.out.println(s1.getCollege());

//        System.out.println(college.name);
        System.out.println(s1.getCollege().name);
        s1.getCollege().name = "Dite";
        System.out.println(s1.getCollege().name);
    }
}
// creating a immutable class
// not purely immutable class
final class Student{
    private final int age ;
    private final String name;
    private final College college;

    Student(int age , String name, College college){
        this.age = age;
        this.name = name;
        this.college = college;
    }
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    public College getCollege(){
        return this.college;
    }

}
// creating a mutable class named College
class College{
    String name;
    String address;
    College(String name,String address){
        this.name = name;
        this.address = address;
    }

}