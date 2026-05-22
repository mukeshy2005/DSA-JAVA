package javaFullCourse.Lecture24;
import java.util.Scanner;
/* dynamic polymorphism*/
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your payment method");
        System.out.println("1.Payment via creditcard");
        System.out.println("2.Payment via debitcard");
        int choice = sc.nextInt();
        Payment p = null ; /*reference variable p is initialized with null */
        switch (choice){
            case 1 : p = new CreditCard();
            break;
            case 2 : p = new DebitCard();
            break;
            default :System.out.println("Wrong choice");

        }
        if( p != null ){
            p.pay();
        }


    }
}
interface Payment{
    public void pay();
}
class CreditCard implements Payment{
    @Override
    public void pay() {
        System.out.println("paying through credit card");
    }
}
class DebitCard implements Payment{
    @Override
    public void pay() {
        System.out.println("paying through debit card");
    }
}