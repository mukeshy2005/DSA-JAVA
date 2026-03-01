package javaFullCourse.Lecture08;
import java.util.*;
public class Solution {
   // contain Solution of Lecture 08
   public static void main(String [] args) {
	   Scanner sc = new Scanner(System.in);
       /* 
       // Question 1: Print a Square Pattern
	   System.out.println("Enter number of rows ");
	   int n = sc.nextInt();
	   
	   for ( int i = 1 ; i <= n ; i++ ) {
		   for ( int j = 1 ; j <= n ; j++ ){
			   System.out.print("*");
		   }
		   System.out.println();
	   }
           */
/*
       //Question 2: Print Perpendicular Line (Easy)
       System.out.println("enter number ");
       int n = sc.nextInt();
       for(int i = 1; i <= n ; i++) {
           for(int j = 1; j <= n; j++) {
		   if( i == 1 || j == 3 ) {
			   System.out.print("*");
   }else {
	   System.out.print(" ");
   }
	   }
   System.out.println();
       }*/
	   // Draw a right angled triangle 
	   System.out.println("enter number");
	   int n = sc.nextInt();

	 /*  for(int i = 1; i<=n; i++) {// for printing reverse triangle we need to change (int i = n; i >=1; i--)
		   for(int j = 1; j<=i; j++) {// keep j as it ies 
			   System.out.print("*");
		   }
		   System.out.println();
	   }*/
	  /* 
	   for(int i = n; i >=1;i--){
		   for(int j = 1; j<=i;j++){
			   System.out.print("*");
		   }
		   System.out.println();
	   }
		   */
		  // question 5 
		  // Solution
		  /* 
		   for(int i = 1; i<=n ; i++) {
            for( int j = 1; j <= n; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
	*/
   }
  

}
