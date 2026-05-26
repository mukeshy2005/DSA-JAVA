package javaFullCourse.Lecture24;

public class Demo7 {
    public static void main(String[] args) {
        S s = new S();
        s.fun();
    }
}
// java Resolution Priority Rule
interface M {
   default void fun(){
       System.out.println("fun inside M interface ");
   }
}
class N {
   public void fun(){
        System.out.println("fun inside N class ");
    }
}
class S extends N implements M {
    /*apne app class wala method call ho jayega*/
}