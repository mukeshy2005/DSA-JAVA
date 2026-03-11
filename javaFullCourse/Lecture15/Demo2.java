package javaFullCourse.Lecture15;
// use of string  argument - String [] args
public class Demo2 {
    public static void main(String[] args) {
       System.out.println(" number of argument "+args.length);

       for( int i = 0 ; i <args.length;i++){
           System.out.println(i+" "+args[i]);
       }
    }
}
// giving input to the string argument array was useful in previous time when we used to run the code through terminal
// we used to specify the configuration like intput.txt and output.txt
// it is useful in spring boot