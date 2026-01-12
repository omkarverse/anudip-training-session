// Checked Exception for Banking System
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(double balance, double amount) {
        super("Insufficient funds. Current balance: " + balance +
              ", Deficit amount: " + (amount - balance));
    }
}

// BankAccount class
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

// Unchecked Exception for Age Validation
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// VoterRegistration class
class VoterRegistration {

    public void validateAge(int age) {
        if (age < 18) {
            throw new InvalidAgeException("Invalid age: " + age +
                    ". Must be 18 or above to register.");
        }
        System.out.println("Age validated. Registration successful.");
    }
}

// Main class
public class ValidationDemo {
    public static void main(String[] args) {

        // Banking system validation
        BankAccount account = new BankAccount(5000);
        try {
            account.withdraw(8000);
        } catch (InsufficientFundsException e) {
            System.out.println("Banking Error: " + e.getMessage());
        }

        // Age eligibility validation
        VoterRegistration voter = new VoterRegistration();
        try {
            voter.validateAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Registration Error: " + e.getMessage());
        }
    }
}
