public class CDAccount extends Account {
    private double interestRate;
    private int durationMonths;
    private boolean earlyWithdrawal = false;
    private boolean isMatured = false;

    public CDAccount(String accountNumber, double initialDeposit, int durationMonths) {
        super(accountNumber);
        this.balance = initialDeposit;
        this.durationMonths = durationMonths;
        setInterestRateBasedOnDurationAndBalance();
        addTransaction("Initial Deposit", initialDeposit);
    }

    private void setInterestRateBasedOnDurationAndBalance() {
        if (durationMonths <= 12) {
            if (balance <= 5000) {
                interestRate = 0.02;
            } else if (balance <= 20000) {
                interestRate = 0.03;
            } else {
                interestRate = 0.04;
            }
        } else if (durationMonths <= 24) {
            if (balance <= 5000) {
                interestRate = 0.025;
            } else if (balance <= 20000) {
                interestRate = 0.035;
            } else {
                interestRate = 0.045;
            }
        } else if (durationMonths <= 36) {
            if (balance <= 5000) {
                interestRate = 0.03;
            } else if (balance <= 20000) {
                interestRate = 0.04;
            } else {
                interestRate = 0.05;
            }
        } else {
            interestRate = 0;
        }
    }


    @Override
    public void deposit(double amount) {
        System.out.println("Deposits are not allowed after initial setup for CD Accounts.");
    }

    @Override
    public void withdraw(double amount) {
    }

    public void liquidate() {
        if (!earlyWithdrawal) {
            double penalty = calculateInterestEarned() / 2;
            balance -= penalty;
            addTransaction("Early Withdrawal Penalty", penalty);
            earlyWithdrawal = true;
        } else {
            System.out.println("CD Account already liquidated.");
            return;
        }
        addTransaction("Liquidation", balance);
        System.out.println("CD Account " + getAccountNumber() + " has been liquidated. Final balance (after penalties): $" + balance);
        balance = 0;
    }


    private double calculateInterestEarned() {
        return balance * interestRate;
    }

    public void applyInterest() {
        if (!earlyWithdrawal && !isMatured) {
            double interestEarned = calculateInterestEarned();
            balance += interestEarned / 12;
            addTransaction("Interest", interestEarned);
        } else {
            System.out.println("Interest already applied or account closed due to early withdrawal.");
        }
    }

    public void decrementDuration() {
        if (durationMonths > 0) {
            durationMonths--;
            if (durationMonths == 0) {
                isMatured = true; // CD has reached its duration limit
                System.out.println("CD Account " + getAccountNumber() + " has matured.");
            }
        }
    }
}
