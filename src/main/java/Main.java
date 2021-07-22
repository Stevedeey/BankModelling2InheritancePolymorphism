import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Account accounts[] = new Account[10];
        int numAccount = 0;
        int choice;
        do{
            choice = menu(keyboard);
            System.out.println();

            if(choice == 1 ){
                accounts[numAccount++] = createAccount(keyboard);
            }else if(choice == 2 ){
                doDeposit(accounts, numAccount ,keyboard);
            }
            else if(choice == 3 ){
                withdraw(accounts, numAccount ,keyboard);
            }
            else if(choice == 3 ){
                applyInterest(accounts, numAccount ,keyboard);
            }
            else {
                System.out.println("Good bye!!!");
            }
            System.out.println();
        }while(choice !=5);
    }



    
    public static int searchAccount(Account accounts[], int count, int accountNumber){
        for (int i  = 0; i < count; i++) {
            if(accounts[i].getAccountNumber() == accountNumber){
                return  i;
            }
        }
        return -1;
    }

    public static void doDeposit(Account accounts[], int count, Scanner keyboard){

        System.out.println("\n Please enter account Number ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

      if(index >= 0){
          System.out.print("Please enter Deposit Amount: ");
          double amount = keyboard.nextDouble();

          accounts[index].deposit(amount);

      }
      else {
          System.out.println("No account exist with AccountNumber "+accountNumber);
      }
    }

    public static void withdraw(Account accounts[], int count, Scanner keyboard){

        System.out.println("\n Please enter account Number ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0){
            System.out.print("Please enter amount to withdraw: ");
            double amount = keyboard.nextDouble();

            accounts[index].withdraw(amount);

        }
        else {
            System.out.println("No account exist with AccountNumber "+accountNumber);
        }
    }

    public static void applyInterest(Account accounts[], int count, Scanner keyboard){

        System.out.println("\n Please enter account Number ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0){
            ((SavingsAccount)accounts[index]).applyInterest();
        }
        else {
            System.out.println("No account exist with AccountNumber "+accountNumber);
        }
    }


    public static Account createAccount(Scanner keyboard) {

        Account account = null;
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.println("Enter Account Number");
        accountNumber = keyboard.nextInt();

        if(choice == 1){
            System.out.println("Enter Transaction Fee ");
            double fee = keyboard.nextDouble();
            account = new CheckingAccount(accountNumber, fee);

        }
        else{
            System.out.println("Please enter interest rate");
            double ir = keyboard.nextDouble();

            account = new SavingsAccount(accountNumber, ir);
        }
        return account;
    }

    public static int accountMenu(Scanner keyboard) {
        System.out.println("Select Account Type ");
        System.out.println("1. Checking Account.");
        System.out.println("2. Savings Account.");

        int choice;
        do {
            System.out.println("Enter an option...");
            choice = keyboard.nextInt();
        } while (choice < 1 || choice > 4);

        return choice;
    }

    public static int menu(Scanner keyboard) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Fund");
        System.out.println("3. Withdraw Fund");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;
        do {
            System.out.println("Select an option..");
            choice = keyboard.nextInt();
        } while (choice < 1 || choice > 5 );

        return choice;
    }
}
