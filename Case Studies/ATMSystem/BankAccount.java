package ATMSystem;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private final String pin;
    private double balance;
    private final List<Transaction> transactionHistory = new ArrayList<>();

    public BankAccount(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }
    
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        transactionHistory.add(new Transaction(Transaction.TransactionType.WITHDRAWAL, amount, balance));
        return true;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction(Transaction.TransactionType.DEPOSIT, amount, balance));
        }
    }
}