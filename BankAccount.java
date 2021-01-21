import java.util.Scanner;

public class BankAccount {
    private String accountName;
    private  int accountId;
    private double balance;
    private double PreTrn;
    BankAccount() {

    }
    BankAccount(String accountName,int accountId,double balance){
        this.accountName= accountName;
        this.accountId = accountId;
        this.balance = balance;
    }
    void deposit(int amount)
    {
        if(amount != 0)
        {
            balance = balance + amount;
            PreTrn = - amount;
        }
    }
    void withdraw(int amount)
    {
        if(amount != 0 && balance > amount)
        {
            balance = balance-amount;
            PreTrn = amount;
        }
    }
    void getPrevTrn() {
        if (PreTrn > 0) {
            System.out.println("Deposited Amount:" + PreTrn);
        }
        else if (PreTrn < 0){
            System.out.println("Withdrawal Amount: "+Math.abs(PreTrn) );
        }
        else
            System.out.println("Error Transaction.");
    }
    void showMenu()
    {
        char choice = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome "+accountName);
        System.out.println("Account Number: "+accountId);
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction.");
        System.out.println("E. Exit");

        do {
            System.out.println("-------------------------------------------");
            System.out.println("Please Enter an Option ");
            choice = sc.next().charAt(0);
            System.out.println("\n");

            switch(choice)
            {
                case 'A':
                    System.out.println("--------------------------------");
                    System.out.println("Current Balance: "+balance);
                    System.out.println("---------------------------------");
                    break;
                case 'B':
                    System.out.println("--------------------------------");
                    System.out.println("Enter the amount: ");
                    System.out.println("--------------------------------");
                    int amount = sc.nextInt();
                    deposit(amount);
                    break;
                case 'C':
                    System.out.println("--------------------------------");
                    System.out.println("Enter the amount: ");
                    System.out.println("--------------------------------");
                    amount = sc.nextInt();
                    withdraw(amount);
                    break;
                case 'D':
                    System.out.println("--------------------------------");
                    getPrevTrn();
                    System.out.println("--------------------------------");
                    break;
                case 'E':

                    break;
                default:
                    System.out.println("Invalid Option. Try Again.");
                    break;
            }
        }
        while(choice != 'E');

        System.out.println("Thank you for choosing us.");
    }

}
