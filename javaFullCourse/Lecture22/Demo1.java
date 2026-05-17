package javaFullCourse.Lecture22;
// using equals method
public class Demo1 {
    public static void main(String [] args){
        Student1 s1 = new Student1("mukesh",21);
        Student1 s2 = new Student1("mukesh",21);
        Student1 s3 = null; // this  way we will recieve null  pointer exception
        Integer i = 28; // class cast exception
        System.out.println(s1.equals(i)); // this will return false (will only compare the references
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
        // to remove null pointer exception
        if (obj == null){
            return false;
        }
        // check if both classes are of student type
        // if not check will receive class cast exception
        if (obj.getClass()!= this.getClass()){
            return false;
        }
        Student1 s = (Student1)obj;
        return (this.name == s.name && this.age == s.age);  // will return because comparing the value instead of reference variable
        // use the reference variable used above
    }

}