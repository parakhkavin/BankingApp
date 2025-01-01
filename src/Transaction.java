import java.time.LocalDate;

public class Transaction {
    private String transactionType;
    private double amount;
    private LocalDate date;

    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return date + ": " + transactionType + " - $" + amount;
    }
}
