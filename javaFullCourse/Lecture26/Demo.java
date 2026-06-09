package javaFullCourse.Lecture26;

public class Demo {
    public static void main(String[] args) {
        /*Topic --> UpCasting*/
        String s = "hello";
        Object obj  = s;
        System.out.println(obj);

        /*Topic --> DownCasting*/
        Object obj1 = "hello";
        String s1 = (String)obj;
        System.out.println(s1);

        /*lets us see the case in which downcasting is dangerous */
        Object obj2 =  10;
        String s2 = (String)obj2; // ClassCastException
    }
}
