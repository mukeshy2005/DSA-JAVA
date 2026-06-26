package javaFullCourse.ExceptionHandling;
//Default Exception Handling
//Prints the stack trace of exception
public class Demo {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;

        methodA(a,b);
    }
    public static void methodA(int a , int b){
        methodB(a,b);
    }
    public static void methodB(int a, int b){
        System.out.println(a/b);
    }
}

/*
* /home/mukeshyadav/.jdks/openjdk-25.0.2/bin/java -javaagent:/home/mukeshyadav/Downloads/idea-IU-252.26830.84/lib/idea_rt.jar=32823 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/mukeshyadav/DSA-JAVA/javaFullCourse/out/production/javaFullCourse javaFullCourse.ExceptionHandling.Demo
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at javaFullCourse.ExceptionHandling.Demo.methodB(Demo.java:15)
	at javaFullCourse.ExceptionHandling.Demo.methodA(Demo.java:12)
	at javaFullCourse.ExceptionHandling.Demo.main(Demo.java:9)

Process finished with exit code 1
*/
