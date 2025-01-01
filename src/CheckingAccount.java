public class CheckingAccount extends Account {
    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 1.0;
    private static final double OVERDRAFT_FEE = 100.0;
    private int transactionCount;
    private boolean overdraftUsed = false;

    public CheckingAccount(String accountNumber) {
        super(accountNumber);
        this.transactionCount = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit", amount);
        incrementTransactionCount();
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            addTransaction("Withdrawal", amount);
            System.out.println("Withdrawn from checking account.");
        } else if (!overdraftUsed) {
            balance -= amount;
            balance -= OVERDRAFT_FEE;
            overdraftUsed = true;
            addTransaction("Overdraft Fee", OVERDRAFT_FEE);
            addTransaction("Withdrawal", amount);
            System.out.println("Withdrawn from checking account.");
            System.out.println("Overdraft Fee of $100 applied.");
        } else {
            System.out.println("Withdrawal declined: Insufficient funds and overdraft already used.");
            return;
        }
        incrementTransactionCount();
    }

    private void incrementTransactionCount() {
        transactionCount++;
        if (transactionCount > FREE_TRANSACTIONS) {
            balance -= TRANSACTION_FEE;
            addTransaction("Transaction Fee", TRANSACTION_FEE);
            System.out.println("Transaction Fee of $1 applied.");
        }
    }

    public void resetMonthlyLimits() {
        transactionCount = 0;
        overdraftUsed = false;
    }
}
