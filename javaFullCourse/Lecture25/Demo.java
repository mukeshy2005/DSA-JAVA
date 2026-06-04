package javaFullCourse.Lecture25;

public class Demo {
    public static void main(String[] args) {
//        String s1 = "hello";
//        s1.concat(" world");
//        System.out.println(s1);
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2); //---> true as both point to same object in the string pool no new object is created
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s3 == s4);//---> false as compare the reference both point to different object
        String s5 = "hello";
        s5 = "world";
        System.out.println(s5);
    }
}
