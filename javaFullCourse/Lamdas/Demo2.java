package javaFullCourse.Lamdas;

public class Demo2 {
    public static void main() {
        // lamda expression (paramter)-> expression
        // -> represent map to

        Maths m = new Maths(2,3);
        System.out.println(m.sum(9,9));
    }



}
class Maths {
    int a;
    int b;

    public Maths(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int sum(int a, int b) {
        return a + b;
    }
}