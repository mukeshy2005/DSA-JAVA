package javaFullCourse.Lecture22;
// using equals method
public class Demo1 {
    public static void main(String [] args){
        Student1 s1 = new Student1("mukesh",21);
        Student1 s2 = new Student1("mukesh",21);
        System.out.println(s1.equals(s2)); // this will return false (will only compare the references
    }
}
// we can Override the equals method
class Student1 {
    String name;
    int age;
    Student1(String name , int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public boolean equals(Object obj){
        Student1 s = (Student1)obj;
        return (this.name == s.name && this.age == s.age);  // will return because comparing the value instead of reference variable
        // use the reference variable used above
    }

}