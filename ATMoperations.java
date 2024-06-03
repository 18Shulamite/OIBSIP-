import java.util.Scanner;

public class ATMoperations {
    private Scanner scanner;
    private User user;
    private Account account;

    public ATMoperations() {
        this.scanner = new Scanner(System.in);
        this.user = new User("admin", "1234");
        this.account = new Account();
    }

    public void start() {
        System.out.println("Welcome to the ATM!");
        if (authenticateUser()) {
            showMenu();
        } else {
            System.out.println("Invalid user ID or PIN.");
        }
    }

    private boolean authenticateUser() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String userPin = scanner.nextLine();
        return user.getUserId().equals(userId) && user.getUserPin().equals(userPin);
    }

    private void showMenu() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    performWithdraw();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (Transaction transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private void performWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void performDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    private void performTransfer() {
        Account targetAccount = new Account(); // In real applications, you would select an existing account
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (account.transfer(targetAccount, amount)) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }
}
