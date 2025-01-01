public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.01; // 1%

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit", amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
        addTransaction("Withdrawal", amount);
    }

    public void applyInterest() {
        double monthlyInterestRate = INTEREST_RATE / 12;
        double interest = balance * monthlyInterestRate;
        deposit(interest);
        addTransaction("Interest", interest);
    }

}
