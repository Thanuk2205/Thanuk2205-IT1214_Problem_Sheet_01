import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public void displayInfo() {
        System.out.printf("Account Number: %d, Holder: %s, Balance: %.2f%n", accountNumber, accountHolder, balance);
    }
}

class Bank {
    private BankAccount[] accounts = new BankAccount[5];
    private int count = 0;

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count++] = account;
        } else {
            System.out.println("Bank account limit reached.");
        }
    }

    public void withdrawFromAccount(int accNumber, double amount) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accNumber) {
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal successful.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account not found.");
        }
    }

    public void displayAllAccounts() {
        System.out.println("\n--- All Accounts ---");
        for (int i = 0; i < count; i++) {
            accounts[i].displayInfo();
        }
    }
}

public class BankAccountManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        System.out.print("Enter account number to withdraw from: ");
        int accNum = scanner.nextInt();

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        bank.withdrawFromAccount(accNum, amount);

        bank.displayAllAccounts();
    }
}
