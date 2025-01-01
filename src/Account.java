import java.util.ArrayList;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected ArrayList<Transaction> transactions;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    protected void addTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount));
    }

    public void printTransactionHistory() {
        System.out.println("Transaction history for account " + accountNumber);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
