package javaFullCourse.Lecture23;
// discussing enums in java
// we came with a problem in with payment status in application --> either show success , failed ,pending
public class Demo {
    public static void main(String [] args){
//        String status = PaymentStatus.SUCCESS;
//        System.out.println(status);
//        status = 100;// this 100 does not make any sense to the application as 100 is not defined , but logically for the code it is correct so it will compile and run
        //Because status is just an integer, the Java compiler thinks, "100 is an integer, so this is perfectly fine!" It will compile and run without any errors.
//        System.out.println(status);

        //poor readability
//        if(status == 2){
            //user has to look what 2 signifies int the enum
         //   if(status == 2)—is known as the "Magic Number" problem.
//        }
//        if(status == ROLE.ADMIN){
            //status will compare with integer and ROLE.ADMIN has value integer 1 , which mislead to payementstatus
            //It has zero awareness of the context. In a real-world application, a bug like this could accidentally grant a standard user Admin privileges just because their payment succeeded!
//        }
//        if(status == "Success" ){
//            // uppercase problem
//        }


    }
}
// problems with this approach
// 1.type safety
//2.poor readability
//3.no grouping of related entities
//4. duplicate value are also allowed

/* one solution that comes in mind why not to use string
* but string will bring new problems , their comparison is slow , case problem*/
/*
class PaymentStatus{
    //we have the constant
//    public static final int SUCCESS = 1;
//    public static final int FAIL = 2;
//    public static final int PENDIGN = 3;
    public static final String SUCCESS = "success";
    public static final String FAIL = "failed";
    public static final String PENDIGN = "pending";
}*/
class ROLE{
    public static final int ADMIN = 1;
    public static final int USER = 2;
}
