package javaFullCourse.Lecture09;

public class Demo {
    public static void main(String[] args) {
        // This is a demo class for Lecture 09
        // Declare and Define an array
        // int [] rollNum ;// this is declration
        // rollNum = new int[3;] // this is defining an array
        // we do both in single line
        // int [] rollNum = new int [3]; // declration and defining
        //now storing roll number 101 , 102 and 103 in the array at index 0,1,3
        // rollNum [0] = 101;
        // rollNum [1] = 102;
        // rollNum [2] = 103;
        // // to print rollNum e.g. 102
        // System.out.println(rollNum [2]);

        //since above method of storing roll number was timetaking and we have manually store each roll number;
        int [] arr = new int [4];
        int rollNum = 101;
        // storing rollNum using loops
        for(int i = 0; i < 4; i++) {
            arr [i] = rollNum;
            rollNum++;
        }
        // we try to print roll number 102;
        // System.out.println(arr[1]);
        
        // to print all the array using loops again
        for(int i = 0 ; i < arr.length; i++) { // arr.length is used to get the size of the array
            System.out.println(arr [i]);
        }
    }
}
