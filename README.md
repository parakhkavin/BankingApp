
# Banking Application

Welcome to the Banking Application! This Java-based application provides a simulated banking environment with support for Savings, Checking, and Certificate of Deposit (CD) accounts. It is designed for simplicity, making it an excellent tool for exploring core banking functionalities and programming concepts.

---

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [System Requirements](#system-requirements)
4. [Installation and Setup](#installation-and-setup)
5. [How to Use](#how-to-use)
6. [Known Issues](#known-issues)
7. [Future Enhancements](#future-enhancements)
8. [Technical Notes](#technical-notes)
9. [License](#license)
10. [Author](#author)

---

## Introduction

The Banking Application is a simple simulation tool for basic banking operations. Users can create and manage accounts, perform transactions, and simulate time passage for interest calculations and monthly resets. This project highlights key object-oriented programming principles and serves as a foundation for further development.

---

## Features

### Account Management
- **Savings Account**: Earn interest on deposits and manage withdrawals.
- **Checking Account**: Perform unlimited deposits and withdrawals.
- **CD Account**: Earn higher interest rates, with penalties for early withdrawals.

### Transactions
- Deposit and withdraw funds.
- Liquidate CD accounts with automatic penalty application.

### Account Monitoring
- Check balances for all account types.
- View detailed transaction histories.

### Time Simulation
- Simulate time passage to:
  - Apply interest.
  - Reset monthly withdrawal limits (Savings Account).

---

## System Requirements

- **Java Version**: JDK 8 or later.
- **Operating System**: Windows, macOS, or Linux.

---

## Installation and Setup

### Step 1: Clone the Repository
Download or clone the project files to your local machine.

### Step 2: Compile the Source Files
Navigate to the project directory and compile all Java files:
```bash
javac Account.java SavingsAccount.java CheckingAccount.java CDAccount.java Transaction.java Main.java
```

### Step 3: Run the Application
Execute the `Main` class to start the application:
```bash
java Main
```

---

## How to Use

### Step 1: Launch the Application
Run the `Main` class and follow the on-screen prompts.

### Step 2: Perform Banking Operations
- **Create Accounts**: Enter account type and details.
- **Deposit/Withdraw Funds**: Follow prompts for Savings and Checking accounts.
- **Liquidate CD Accounts**: Confirm liquidation to withdraw funds (penalty applied).

### Step 3: Monitor Accounts
- Check balances and transaction histories using the respective options.

### Step 4: Simulate Time Passage
Choose the time simulation option to:
- Apply monthly interest.
- Reset Savings Account withdrawal limits.

---

## Known Issues

- **Data Persistence**: Account and transaction data are not saved between sessions. Restarting the application resets all data.

---

## Future Enhancements

### Planned Features
- Implement persistent storage for saving and loading account data.
- Add user authentication for enhanced security.
- Introduce support for recurring payments and scheduled transactions.
- Enhance error handling and input validation.

---

## Technical Notes

- **Interest Calculation**: Interest rates are applied yearly but divided into monthly increments (`interest_rate / 12`).
- **Early Withdrawal Penalty**: CD account liquidations incur a predefined penalty deducted from the account balance.

---

## License
- This project is licensed under the GNU 3.0 License. See the `LICENSE` file for details.

---

## Author
Kavin Parakh
Drexel University
