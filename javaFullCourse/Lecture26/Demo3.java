package javaFullCourse.Lecture26;

public class Demo3 {
    public static void main(String [] args){
        /*this time i want to make it string*/
        Pair <String>p = new Pair<String>("hello","mukesh");
        System.out.println(p.first+" , "+  p.second);
        /*for number or integer*/
        Pair<Integer> p1 = new Pair<Integer>(1,2);
        System.out.println(p1.first+" , "+  p1.second);
        //lets us make it for the character
        Pair <Character> p2 = new Pair<Character>('a','b');
        System.out.println(p2.first+" , "+  p2.second);

        /*object of fun class*/
        fun<Integer,String> f = new fun <Integer, String>(10,"hello");
        System.out.println(f.first+" , "+  f.second);
    }
}
/*to make this generic so that i don't have to create a different object or class for different datatype*/
/*currently it only expect the single data type */
class Pair<T>{
    T first;
    T second;

    Pair(T first, T second){
        this.first = first;
        this.second = second;
    }
}
/*with two different data type ---> generics*/
class fun<X,Y>{
    X first ;
    Y second;
    fun(X first,Y second){
        this.first = first;
        this.second = second;
    }
}