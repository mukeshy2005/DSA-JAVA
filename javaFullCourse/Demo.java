//Printing number having decimal places.
package javaFullCourse;
public class Demo {
    public static void main(String[] args){
     Float f = .7f;
     Double d = 3.4889933973;
    //  System.out.println(f);
    System.out.printf("%.20f%n",f);
    System.out.println("most of the time we use Double because it has 2 precsion"+" "+d); //we can use printf("%.20f%n",f) to print decimal places 
    }
}