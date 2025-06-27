package ATMSystem;

public class ATM {
    private BankAccount currentAccount;

    public boolean login(BankAccount account, String pin) {
        if (account.validatePin(pin)) {
            this.currentAccount = account;
            System.out.println("SUCCESS: Login successful. Welcome!");
            return true;
        } else {
            System.out.println("ERROR: Invalid PIN.");
            return false;
        }
    }
    
    public void logout() {
        this.currentAccount = null;
        System.out.println("Thank you for using our ATM. Goodbye!");
    }

    public void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", currentAccount.getBalance());
    }

    public void withdraw(double amount) {
        if (currentAccount.withdraw(amount)) {
            System.out.printf("SUCCESS: Withdrew $%.2f.%n", amount);
            checkBalance();
        } else {
            System.out.println("ERROR: Insufficient funds or invalid amount.");
        }
    }

    public void deposit(double amount) {
        currentAccount.deposit(amount);
        System.out.printf("SUCCESS: Deposited $%.2f.%n", amount);
        checkBalance();
    }
    
    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        if (currentAccount.getTransactionHistory().isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction t : currentAccount.getTransactionHistory()) {
                System.out.println(t);
            }
        }
        System.out.println("-------------------------");
    }
}