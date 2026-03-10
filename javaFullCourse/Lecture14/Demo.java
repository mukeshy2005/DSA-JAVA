package javaFullCourse.Lecture14;
public class Demo{
    public static void main(String[] args) {
        //call by value
        int x = 4;
        int y = 5;

        System.out.println(x+" , "+y);

        add(x,y);
        System.out.println(x+" , "+y); // output is 4,5 instead of 14, 15


    }
    static void add(int a, int b){
        a = a+10;
        b = b+10;
    }
}