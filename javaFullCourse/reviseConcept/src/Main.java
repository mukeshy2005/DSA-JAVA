public class Main{
    public static void main(String[] args) {
        // understanding getters and setter through example
        Bank  bank = new Bank();
        System.out.println(bank.getBalance());
        bank.setBalance(500);
        bank.setInformation("rojan",22);

    }
}
// creating a Bank class
class Bank{
    private int balance = 200;
    private String name = " mukesh ";
    private int age = 20;

    public void setInformation(String name , int age ){
        this.name = name;
        this.age = age;
        System.out.println(this.name + " " + this.age);
    }

    public int getBalance(){
        return balance;
    }
    public void setBalance(int newBalance){
        if(newBalance > 200){
            this.balance = this.balance + newBalance;
            System.out.println(this.balance);
        }
        else{
            System.out.println("add amount more than 200");
        }
    }


}