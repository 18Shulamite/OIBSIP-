import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactionHistory;

    public Account() {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public boolean transfer(Account targetAccount, double amount) {
        if (withdraw(amount)) {
            targetAccount.deposit(amount);
            transactionHistory.add(new Transaction("Transfer", amount));
            return true;
        }
        return false;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
