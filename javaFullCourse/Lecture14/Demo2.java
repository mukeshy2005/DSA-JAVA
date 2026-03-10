package javaFullCourse.Lecture14;

public class Demo2 {
    public static void main(String[] args) {
        // call by reference;
        Random r1 = new Random(4,6);
        System.out.println(r1.x+" , "+r1.y);
        addTen(r1);
        System.out.println(r1.x+" , "+r1.y);

    }
    static void addTen(Random r1){
        r1.x = r1.x + 10;
        r1.y = r1.y + 10;
    }

}
class Random {
    int x ;
    int y ;

    Random(int x , int y){
        this.x = x;
        this.y = y;
    }
}
