package javaFullCourse.Lecture19;

public class Demo3 {
    public static void main(String[] args) {

        Outer outer = new Outer();
    Outer.Inner inner = new Outer.Inner(outer);

        inner.printNum();
    }
}
class Outer{
    static int x = 10;
    int y = 3;
    static class Inner{
        //creating a variable
        Outer outer;
        Inner(Outer outer){
            this.outer = outer;
        }

        void printNum(){
            System.out.println(x);
            System.out.println(outer.y);
            // there are two was to acces non static variale one though passsing reference
            // another through constructor

        }

    }
}

class BankAccount{
    private static class interestCalculator{
        static double yearlyInterest(double principal, double rate ){
            return principal * rate;
        }
    }
    public  double computeInterest(double principal){
        return interestCalculator.yearlyInterest(principal, 2);
    }
}