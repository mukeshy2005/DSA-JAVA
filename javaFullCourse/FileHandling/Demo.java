package javaFullCourse.FileHandling;

import java.io.File;
import java.io.IOException;

public class Demo {
    static void main() {
        // creating a file in try catch block to handle exception also
        try {
            File myfile = new File("hello.text");
            if(myfile.createNewFile()){
                System.out.println("File created"+myfile.getName());
            }
            else{
                System.out.println("File already exists");
            }
        }
        catch(IOException e) {
            System.out.println("an error occured Error");
        }
    }
}
