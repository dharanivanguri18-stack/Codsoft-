import java.util.Scanner;

/* Class to represent the user's bank account */
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } 
        else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } 
        else {
            balance -= amount;
            System.out.println("Withdrawal successful. Please collect your cash.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

/* Class to represent the ATM machine */
class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount acc) {
        account = acc;
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("\n---- ATM MENU ----");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void startATM() {
        int choice;
        double amount;

        while (true) {
            showMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    amount = sc.nextDouble();
                    account.deposit(amount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    amount = sc.nextDouble();
                    account.withdraw(amount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

/* Main class */
public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // initial balance
        ATM atm = new ATM(userAccount);
        atm.startATM();
    }
}
