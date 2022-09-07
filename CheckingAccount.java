/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB203_64
 */
public class CheckingAccount extends Account {
    private double credit;
    
    public CheckingAccount(){
        super(0, "");
        this.credit = 0;
    }
    public CheckingAccount(double balance, String name, double credit){
        super(balance, name);
        this.credit = credit;
    }
    public void setCredit(double credit){
        if (credit > 0){
            this.credit = credit;
        }
        else{
            System.out.println("Input numbe must be a positive integer.");
        }
    }
    public double getCredit(){
        return credit;
    }
    public void withdraw(double a){
        if (a > 0){
            if((balance - a) > 0){
                balance -= a;
                System.out.println(a + " baht is withdrawn from " + name + ".");
            }
            else if (((balance - a) < 0) && ((balance - a) + credit) > 0){
                balance = 0;
                credit -= a;
                System.out.println(a + " baht is withdrawn from " + name + ".");
            }
            else {
                System.out.println("Not enough money!");
            }
        }
    }
    public void withdraw(String a){
        double d = Double.parseDouble(a);
        if (d>0){
            if ((balance - d) > 0){
                balance -= d;
                System.out.println(d+" baht is withdrawn from "+name+" and your credit balance is "+credit+".");
            }
            else if (((balance - d) < 0) && (((balance - d)+credit) > 0)){
                balance = 0;
                credit -= d;
                System.out.println(d+" bath is withdrawn from "+name+" and your credit balance is "+credit+".");
            }
            else{
                System.out.println("Not enough money!");
            }
        }
    }
    public String toString(){
        return "The "+name+" account has "+balance+" baht and "+credit+" credits.";
    }
}
