import java.util.Scanner;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String message) {
        super(message);
    }
}

class LoginSystem {
    private final String username = "admin";
    private final String password = "1234";
    private int failedAttempts = 0;
    private final int maxAttempts = 3;
    private boolean locked = false;

    void login(String user, String pass)
            throws InvalidUsernameException, InvalidPasswordException,
            AccountLockedException {

        if (locked)
            throw new AccountLockedException("Account is locked.");

        if (!user.equals(username)) {
            failedAttempts++;
            checkAttempts();
            throw new InvalidUsernameException("Invalid username.");
        }

        if (!pass.equals(password)) {
            failedAttempts++;
            checkAttempts();
            throw new InvalidPasswordException("Invalid password.");
        }

        failedAttempts = 0;
        System.out.println("Login successful.");
    }

    private void checkAttempts() throws AccountLockedException {
        if (failedAttempts >= maxAttempts) {
            locked = true;
            throw new AccountLockedException("Maximum login attempts exceeded. Account locked.");
        }
    }
}

public class LoginApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoginSystem system = new LoginSystem();

        try {
            while (true) {
                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                try {
                    system.login(username, password);
                    break;
                } catch (InvalidUsernameException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (InvalidPasswordException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (AccountLockedException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Login process completed.");
            sc.close();
        }
    }
}