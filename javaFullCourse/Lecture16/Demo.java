package javaFullCourse.Lecture16;
//Encapsulation
public class Demo{
    public static void main(String[] args){
        BankAccount b = new BankAccount();

        b.deposit(500);
        b.withdraw(200);

        System.out.println(b.getBalance());
    }
}
class BankAccount{
    private double balance;

    public void deposit(int amount){
        balance +=amount;
    }
    public void withdraw(int amount){
        balance -=amount;
    }
    public double getBalance(){
        return balance;
    }
}

// creating another class for understanding getters/setters

class Student {
    private String name ;
    private int rollNum;
    private int age ;
    private String college;

    public String getName(){
        return name;
    }
    public void setName(String name ){
        this.name = name;
    }
    public int getRollNum(){
        return rollNum;
    }
    public void setRollNum(int rollNum){
        this.rollNum = rollNum;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getCollege(){
        return college;
    }
    public void setCollege(String college ){
        this.college = college;
    }
}