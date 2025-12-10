class BankAccount {
    private String accNo;
    private String name;
    private double bal;
    public BankAccount(String accNo, String name, double bal) {
        this.accNo = accNo;
        this.name = name;
        this.bal = bal;
    }
    public void deposit(double amt) {
        if (amt > 0) {
            bal += amt;
            System.out.println("Deposited: " + amt);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public void withdraw(double amt) {
        if (amt > 0 && amt <= bal) {
            bal -= amt;
            System.out.println("Withdrawn: " + amt);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
    public double getBalance() {
        return bal;
    }
    public void printDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + bal);
    }
}
class SavingsAccount extends BankAccount {
    private double rate;

    public SavingsAccount(String accNo, String name, double bal, double rate) {
        super(accNo, name, bal);
        this.rate = rate;
    }
    public void withdraw(double amt) {
        if (amt > 0 && amt <= getBalance()) {
            super.withdraw(amt);
        } else {
            System.out.println("Withdrawal denied! Amount exceeds balance.");
        }
    }
    public void printDetails() {
        super.printDetails();
        System.out.println("Interest Rate: " + rate + "%");
    }
}
public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("101", "Diksha", 5000);
        a1.deposit(1500);
        a1.withdraw(2000);
        a1.printDetails();
        SavingsAccount s1 = new SavingsAccount("202", "XYZ", 8000, 4.5);
        s1.deposit(1000);
        s1.withdraw(10000);   
        s1.withdraw(2000);    
        s1.printDetails();
    }
}
