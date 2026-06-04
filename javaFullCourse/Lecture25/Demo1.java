package javaFullCourse.Lecture25;

public class Demo1 {
    public static void main(String[] args) {
        /*
        * since we created literal string object will be created inside String pool*/
        String s1 = "ja"+"va";
        String s2 = "java";
        System.out.println(s1==s2); /*true*/

        /*here s3 is literal string object is crated inside the string pool
        * at s4 "wordl" is again a literal string object is created inside the string pool
        * but s3+"wordl" value of s3 is taken as hello at the run time --> object created inside the heap --> hello world*/
        String s3 = "hello";
        String s4 = s3+ " wordl";
        String s5 = "hello wordl";
        System.out.println(s4==s5);// false

        /*string pool --> "hello world "
        * */
        String s6 = "hello wordl";
        String s7 = s6; /*this " = " resolves at the compile time */
        System.out.println(s6==s7); //true

        String s8 = "hello";
        s8 = "world";
        System.out.println(s8); //wordl as output


        /*here s9 object is created inside the heap and a similar object is created inside the string pool as well but will not point to any reference variable
        * s10 object will point to the hello that is already present inside the string pool */
        String s9 = new String("hellow");
        String s10 = "hello";
        System.out.println(s9==s10); // false as the object are present inside the heap and string


    }
}

/*important
* String pool -->"hello" , "world" ,"hello world "
* Heap --> " hello world "*/

