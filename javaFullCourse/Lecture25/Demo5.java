package javaFullCourse.Lecture25;

public class Demo5 {
    public static void main(String[] args) {
        String name = "mukesh yadav";
        int age = 21;
        System.out.println(String.format("hello %s, your age is %s",name,age));
        StringBuilder sb = new StringBuilder("hello");
        sb.append(" mukesh");

        System.out.println(sb);
        sb.insert(0,"yadav");
        System.out.println(sb);
    }
}

