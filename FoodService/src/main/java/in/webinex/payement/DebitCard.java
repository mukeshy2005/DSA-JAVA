package in.webinex.payement;

public  class DebitCard implements PaymentService{
    @Override
    public void payment(){
        System.out.println("payment through debitcard");
    }
}
