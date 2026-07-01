package javaFullCourse.Lecture25;
// there are methods direct array
// charater array
//subset of character array
public class Demo3 {
    public static void main(String[] args) {
        char [] arr = {'m','u','k','e','s','h',' ','y','a','d','a','v'};
        String s = new String(arr);
//        System.out.println(s);
        // now to print specific part
        //there is constructor which takes (arr_name,starting_point,end_point)
        String s1 = new String (arr,0,6);// make sure to remember the inclusive and exclusive concept
        System.out.println(s);
        System.out.println(s1);
        // we can make byte array too
        byte[] arr1 = {97,98,99};
        String s2 = new String(arr1);
        System.out.println(s2);

        /*
        * StringBuilder / StringBuffer*/
        StringBuilder sb = new StringBuilder("hello");
        String s8 = new String(sb);
        System.out.println(s8);

        //similar work can be done by
        String s10 = new String("hello");
        System.out.println(s10);
        String s11 = new String("hello");
        System.out.println(s11);

        //similarly StringBuffer
        StringBuffer sb1 = new StringBuffer("hello");
        String s12 = new String(sb1);
        System.out.println(s12);


    }
}
