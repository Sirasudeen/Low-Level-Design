package ATMSystem;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    enum TransactionType { DEPOSIT, WITHDRAWAL }

    private final TransactionType type;
    private final double amount;
    private final String timestamp;
    private final double balanceAfterTransaction;

    public Transaction(TransactionType type, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public String toString() {
        return "Timestamp: " + timestamp +
               ", Type: " + type +
               ", Amount: " + String.format("%.2f", amount) +
               ", Balance: " + String.format("%.2f", balanceAfterTransaction);
    }
}