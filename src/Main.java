import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SavingsAccount savingsAccount = null;
        CheckingAccount checkingAccount = null;
        List<CDAccount> cdAccounts = new ArrayList<>();


        while (true) {
            System.out.println("\nBanking Application Menu:");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Create CD Account");
            System.out.println("4. Deposit to Savings");
            System.out.println("5. Deposit to Checking");
            System.out.println("6. Withdraw from Savings");
            System.out.println("7. Withdraw from Checking");
            System.out.println("8. Liquidate a CD Account");
            System.out.println("9. Check Balance");
            System.out.println("10. Print Transaction History");
            System.out.println("11. Time Passed (Simulate End of Month)");
            System.out.println("12. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create Savings Account
                    if (savingsAccount == null) {
                        savingsAccount = new SavingsAccount("S001");
                        System.out.println("Savings account created.");
                    } else {
                        System.out.println("Customer savings account already exists.");
                    }
                    break;
                case 2:
                    // Create Checking Account
                    if (checkingAccount == null) {
                        checkingAccount = new CheckingAccount("C001");
                        System.out.println("Checking account created.");
                    } else {
                        System.out.println("Customer checking account already exists.");
                    }
                    break;
                case 3:
                    System.out.print("Enter initial deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    System.out.print("Enter duration in months: ");
                    int duration = scanner.nextInt();
                    CDAccount cdAccount = new CDAccount("CD" + (cdAccounts.size() + 1), initialDeposit, duration);
                    cdAccounts.add(cdAccount);
                    System.out.println("CD account created.");
                    break;
                case 4:
                    // Deposit to Savings
                    if (savingsAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        savingsAccount.deposit(amount);
                        System.out.println("Deposited to savings account.");
                    } else {
                        System.out.println("Savings account does not exist.");
                    }
                    break;
                case 5:
                    // Deposit to Checking
                    if (checkingAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        checkingAccount.deposit(amount);
                        System.out.println("Deposited to checking account.");
                    } else {
                        System.out.println("Checking account does not exist.");
                    }
                    break;
                case 6:
                    // Withdraw from Savings
                    if (savingsAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        savingsAccount.withdraw(amount);
                        System.out.println("Withdrawn from savings account.");
                    } else {
                        System.out.println("Savings account does not exist.");
                    }
                    break;
                case 7:
                    // Withdraw from Checking
                    if (checkingAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        checkingAccount.withdraw(amount);
                    } else {
                        System.out.println("Checking account does not exist.");
                    }
                    break;

                case 8:
                    System.out.println("Liquidate a CD Account");
                    if (cdAccounts.isEmpty()) {
                        System.out.println("No CD accounts available for liquidation.");
                    } else {
                        for (int i = 0; i < cdAccounts.size(); i++) {
                            CDAccount cdAcc = cdAccounts.get(i);
                            System.out.println((i + 1) + ". CD Account " + cdAcc.getAccountNumber() + " with balance: $" + cdAcc.getBalance());
                        }
                        System.out.print("Select which CD account to liquidate (1-" + cdAccounts.size() + "): ");
                        int accountIndex = scanner.nextInt() - 1; // Adjust for zero-based index
                        if (accountIndex >= 0 && accountIndex < cdAccounts.size()) {
                            cdAccounts.get(accountIndex).liquidate();
                            cdAccounts.remove(accountIndex);
                        } else {
                            System.out.println("Invalid selection.");
                        }
                    }
                    break;

                case 9:
                    System.out.println("Account balances:");
                    if (savingsAccount != null) {
                        System.out.println("Savings: $" + savingsAccount.getBalance());
                    }
                    if (checkingAccount != null) {
                        System.out.println("Checking: $" + checkingAccount.getBalance());
                    }
                    if (!cdAccounts.isEmpty()) {
                        for (CDAccount cdAcc : cdAccounts) {
                            System.out.println("CD Account " + cdAcc.getAccountNumber() + ": $" + cdAcc.getBalance());
                        }
                    }
                    if (savingsAccount == null && checkingAccount == null && cdAccounts.isEmpty()) {
                        System.out.println("No accounts exist.");
                    }
                    break;

                case 10:
                    // Print Transaction History
                    System.out.println("Transaction histories:");
                    if (savingsAccount != null) {
                        System.out.println("Savings Account:");
                        savingsAccount.printTransactionHistory();
                    }
                    if (checkingAccount != null) {
                        System.out.println("Checking Account:");
                        checkingAccount.printTransactionHistory();
                    }
                    if (!cdAccounts.isEmpty()) {
                        for (CDAccount cdAcc : cdAccounts) {
                            cdAcc.printTransactionHistory();
                        }
                    }
                    break;

                case 11:
                    System.out.print("Enter the number of months passed: ");
                    int monthsPassed = scanner.nextInt();

                    for (int month = 1; month <= monthsPassed; month++) {
                        System.out.println("Processing month " + month + " of " + monthsPassed + "...");

                        // Apply interest to the savings account for each month
                        if (savingsAccount != null) {
                            savingsAccount.applyInterest();
                            System.out.println("Interest applied to Savings Account for month " + month);
                        }

                        // Reset the checking account's monthly transaction limits and overdraft status for each month
                        if (checkingAccount != null) {
                            checkingAccount.resetMonthlyLimits();
                            System.out.println("Monthly limits reset for Checking Account for month " + month);
                        }

                        // Process each CD account for the month
                        for (CDAccount cdAcc : cdAccounts) {
                            // Assuming CDAccount has a method to handle monthly processing that calculates interest
                            cdAcc.applyInterest();
                            cdAcc.decrementDuration();
                            System.out.println("Monthly processing completed for CD Account " + cdAcc.getAccountNumber() + " for month " + month);
                        }

                    }

                    System.out.println(monthsPassed + " month(s) have passed. All accounts have been updated.");
                    break;


                case 12:
                    // Exit
                    System.out.println("Exiting application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
                    break;
            }
        }
    }
}
