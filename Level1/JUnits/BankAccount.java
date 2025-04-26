import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BankAccount {
    private double bal = 0;

    public void deposit(double amt) {
        bal += amt;
    }

    public void withdraw(double amt) {
        if (amt > bal) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        bal -= amt;
    }

    public double getBalance() {
        return bal;
    }

    @Test
    public void testDeposit() {
        BankAccount b = new BankAccount();
        b.deposit(200);
        Assertions.assertEquals(200, b.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount b = new BankAccount();
        b.deposit(300);
        b.withdraw(100);
        Assertions.assertEquals(200, b.getBalance());
    }

    @Test
    public void testInsufficientFunds() {
        BankAccount b = new BankAccount();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            b.withdraw(50);
        });
    }
}
