package in.webinex.payement;

public  class CreditCard implements PaymentService{
    @Override
    public void payment(){
        System.out.println("payment through creditcard");
    }
}
