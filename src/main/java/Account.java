public abstract class Account {
    private int accountNumber;

    protected double balance;

    public Account() {
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    //abstract method

    public  abstract void withdraw(double amount);
    /*
    * Deposit funds as long as amount is greater that 0
    * Apply transaction fee for the checking account
    * */

    public abstract void deposit(double amount);
    /*
    * amount to withdraw must be grater than 0
    * amount must be less than balance*/


}
