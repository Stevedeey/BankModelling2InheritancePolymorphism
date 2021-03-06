public class CheckingAccount extends Account {

    private static double FEE = 2.5;


    public CheckingAccount() {
        super();
    }

    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }


    public void withdraw(double amount) {

        if(amount > 0){
            if(amount + FEE <= balance){
                balance -= amount;
                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -=FEE;
                System.out.printf("Fee of %.2f applied %n", FEE) ;
                System.out.printf("Current Balance is: %.2f ",balance) ;


            }
        }
        else {
            System.out.println("Negative amount cannot be deposited");

        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            //Apply transaction fee
            balance -= FEE;
            System.out.printf("Fee %.2f applied", FEE);
            System.out.printf("Current balance is: %.2f%n", balance);

        } else {
            System.out.println("Negative amount cannot be deposited");
        }

    }
}
