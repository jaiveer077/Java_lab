import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("Deposit amount must be positive.");

        balance += amount;
    }

    void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amount <= 0)
            throw new InvalidAmountException("Withdrawal amount must be positive.");

        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient balance.");

        balance -= amount;
    }
}

public class BankingApplication {

    static BankAccount account = new BankAccount(101, 5000);

    static BankAccount findAccount(int accountNumber)
            throws AccountNotFoundException {

        if (accountNumber != account.accountNumber)
            throw new AccountNotFoundException("Account not found.");

        return account;
    }

    static void deposit(int accountNumber, double amount)
            throws AccountNotFoundException, InvalidAmountException {

        BankAccount acc = findAccount(accountNumber);
        acc.deposit(amount);
    }

    static void withdraw(int accountNumber, double amount)
            throws AccountNotFoundException, InvalidAmountException,
            InsufficientBalanceException {

        BankAccount acc = findAccount(accountNumber);
        acc.withdraw(amount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account number: ");
            int accountNumber = sc.nextInt();

            System.out.print("Enter deposit amount: ");
            double depositAmount = sc.nextDouble();

            deposit(accountNumber, depositAmount);
            System.out.println("Deposit successful.");
            System.out.println("Balance: " + account.balance);

            System.out.print("Enter withdrawal amount: ");
            double withdrawAmount = sc.nextDouble();

            withdraw(accountNumber, withdrawAmount);
            System.out.println("Withdrawal successful.");
            System.out.println("Balance: " + account.balance);

        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}