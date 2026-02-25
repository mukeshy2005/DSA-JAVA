package javaFullCourse;
public class Demo2 {
    public static void main(String[] args) {
        // Relational operator in java , --> ==,!=, > ,< <=, >=
        int a = 5;
        int b = 10;
        boolean c = (a==b);
        System.out.println(c);// false 

        boolean  d = (a!=b);
        System.out.println(d);// true

        boolean e = (a>b);
        System.out.println(e);// false

        boolean f = (a<b);
        System.out.println(f);// true
        boolean g = (a<=b);// any one of the condition is true then it will return true
        System.out.println(g);// true
        byte k = 1;
        k = (byte) (k<<7);
        // k = (byte) (k<<1);// this will give 0 as output we need to understand the resason behind it 
        int i = k<<1;
        System.out.println(i); //outptt will be -128 because when we left shift the bits of 1 by 7 positions, it becomes 10000000 in binary, which is -128 in decimal.
         int m = 1;
        m =  (m<<31);// this will give 0 as output because when we left shift the bits of 1 by 31 positions, it becomes 10000000000000000000000000000000 in binary, which is -2147483648 in decimal. However, since m is an int, it can only hold values up to 2147483647, so it wraps around and becomes 0.
        // m = (m<<1);
        System.out.println(m);// output will be 128 because when we left shift the bits of 1 by 7 positions, it becomes 10000000 in binary, which is 128 in decimal.

    }
}