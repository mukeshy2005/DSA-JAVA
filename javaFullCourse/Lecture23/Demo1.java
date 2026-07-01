package javaFullCourse.Lecture23;

public class Demo1 {
    public static void main(String[] args) {
        //generally
//        int status = PaymentStatus.SUCCESS;
        //now
//        PaymentStatus status = PaymentStatus.SUCCESS;
//        System.out.println(status.name());
        //now we cannot do
//        PaymentStatus status = 100; // will give an error incompatible type can only use PaymentStatus typed "FAILED ,SUCCESS, PENDING"
//        System.out.println(status.name()); //
//        PaymentStatus2 status = PaymentStatus2.SUCCESS; WHY I CANNOT WRITE THIS

    }
}
//ENUM --> Enumeration (enumerated type)
//ENUM --> predefined set of constants
enum PaymentStatus{
    SUCCESS,
    FAILED,
    PENDING
}
class PaymentStatus2{
    //we have the constant
    public static final int SUCCESS = 1;
    public static final int FAIL = 2;
    public static final int PENDIGN = 3;

}