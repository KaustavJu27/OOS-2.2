import java.util.ArrayList;

// Base class Account
class Account {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getter and Setter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount class extending Account
class SavingsAccount extends Account {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    // Getter and Setter for interestRate
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Method to calculate yearly interest
    public double calculateYearlyInterest() {
        return getBalance() * interestRate / 100;
    }

    // Overriding displayDetails to include interest rate and yearly interest
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Yearly Interest: " + calculateYearlyInterest());
    }
}

// CurrentAccount class extending Account
class CurrentAccount extends Account {
    // Constructor
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Overriding displayDetails to specify account type as "Current Account"
    public void displayDetails() {
        System.out.println("Current Account:");
        super.displayDetails();
    }
}

// Manager class to manage accounts
class Manager {
    private ArrayList<Account> accounts = new ArrayList<>();

    // Method to add an account to the list
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to display all accounts
    public void displayAllAccounts() {
        for (Account account : accounts) {
            account.displayDetails();
            System.out.println();
        }
    }
}

// Main class to execute the program
public class Main {
    public static void main(String[] args) {
        // Create an instance of Manager
        Manager manager = new Manager();

        // Create two SavingsAccount objects
        SavingsAccount savings1 = new SavingsAccount("SA001", "Alice", 10000.0, 5.0);
        SavingsAccount savings2 = new SavingsAccount("SA002", "Bob", 15000.0, 4.5);

        // Create three CurrentAccount objects
        CurrentAccount current1 = new CurrentAccount("CA001", "Charlie", 20000.0);
        CurrentAccount current2 = new CurrentAccount("CA002", "David", 25000.0);
        CurrentAccount current3 = new CurrentAccount("CA003", "Eve", 30000.0);

        // Add all accounts to the Manager
        manager.addAccount(savings1);
        manager.addAccount(savings2);
        manager.addAccount(current1);
        manager.addAccount(current2);
        manager.addAccount(current3);

        // Display details of all accounts
        manager.displayAllAccounts();

        // Calculate and print interest for each SavingsAccount
        System.out.println("Interest for Savings Accounts:\n");
        System.out.println("Yearly Interest for " + savings1.getHolderName() + ": " + savings1.calculateYearlyInterest());
        System.out.println("Yearly Interest for " + savings2.getHolderName() + ": " + savings2.calculateYearlyInterest());
    }
}
