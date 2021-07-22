public class SavingsAccount extends Account {

    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterst() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calcInterst();
        System.out.printf("Interst Amount %.2f added to balance", interest);
        deposit(interest);
    }

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;

    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);
            System.out.printf("Current balance is: %.2f %n", balance);

        } else {
            System.out.println("Negative amount cannot be deposited");
        }

    }

    public void withdraw(double amount) {

        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.printf("Amount of %.2f withdrawn from Account %n", amount);
                System.out.printf("Current Balance is: %.2f ", balance);

            }
        } else {
            System.out.println("Negative amount cannot be withdrawn");

        }
    }

}
