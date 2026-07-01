package javaFullCourse.Lecture25;
/*will use all the methods of String*/
public class Demo4 {
    public static void main(String[] args) {
        String name = new String("mukesh");
        System.out.println(name.length());
        System.out.println(name.isEmpty()); // return false
        System.out.println(name.isBlank());//return false

        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1.equals(s2));
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s3.equals(s4));
        System.out.println(s3 == s4);

        //String has override the equals()
        }
}
