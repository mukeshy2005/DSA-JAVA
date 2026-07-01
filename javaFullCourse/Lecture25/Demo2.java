package javaFullCourse.Lecture25;

public class Demo2 {
    public static void main(String[] args) {
        // problem of immutability
        String s = "";
        for (int i = 0 ; i <5 ; i++){
            s += i;
            System.out.println(s);
        }
    }
}
//output will be 0 , 01, 012, 0123,01234