package javaFullCourse.Lecture22;

public class Demo2 {
    public static void main(String [] args) {
        Student3 s1 = new Student3("mukesh", 28);
//        Student3 s2 = new Student3("mukesh", 28);
       Student3 s2 = s1;
       System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode()); // here hashcode of both the object s1 and s2 are same
        System.out.println(s2.hashCode());


    }
}
class Student3 {
    String name;
    int age;
    Student3(String name, int age) {
        this.name = name;
        this.age = age;
    }


}