public class Demo {
    public static void main(String[] args) {
        bank bank1 = new bank(400, "mukesh", 50);
        bank bank2 = new bank( 500,"roahn", 40);
        bank bank3 = new bank( 1000,"vushak", 43);

        System.out.println(bank2.getBalance());
    }
}
class bank{
    private int balance ;
    private String name ;
    private int age;
    public static final int MINIMUM_BALANCE = 1000;
    //creating a constructor
    public bank(int newbalance, String name , int age, ){
        this.balance = newbalance;
        this.name = name;
        this.age = age;
        System.out.println("account is created for " + name);
    }
    // creating getters and setters
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        if(){
            this.balance = balance;
        }
        else{
            System.out.println("balance is invalid");
        }
    }
}