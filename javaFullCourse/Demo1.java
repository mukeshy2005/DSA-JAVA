package javaFullCourse;
public class Demo1 {
    public static void main(String[] args) {
        //Operator in java
        //Arithmatic operator --> +,-,/,*,%, +=, -=, /=,%=, ++,--
        int a = 5;
        int b = 10;
        
        int c =  a+b;
        int d = a-b;
        int e =a*b;
        int f = a/b;
        int g = b%a;
        System.out.println(c+ ","+d+","+e+","+f+","+g);
        
        int h = a +2;
        // h = h+2;
        h+=2;// this is same as h = h+2;
        h-=2;// this is same as h = h-2;
        h*=2;// this is same as h = h*2;    
        h/=2;// this is same as h = h/2;
        h%=2;// this is same as h = h%2;
        System.out.println(h);

        int i = 6;
        i++;// this is same as i = i+1; but can also be written as i+=1;
        i--;// this is same as i = i-1; but can also be written as i-=1; 
         System.out.println(i);

         //preincrement and post increment
          int j = 5;
          j++; // post increment means first use the value of j and then increment it

          ++j;// pre increment means first increment the value of j and then use it

          // J= 7

          int k = j++; // ye do part me samajh sakte hai k = j; , j = j+1;
          // So pahle  j ka value  which is 7 will be assigned to k and then j will be incremented to 8


          System.out.println(j+","+k);

          int l = ++j; // ye do part me samajh sakte hai j = j+1; , l = j;
          // So pahle j will be incremented to 9 and then l will be assigned
        
            System.out.println(j+","+l);
    }
}