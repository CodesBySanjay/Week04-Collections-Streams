import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PasswordValidator {

    public boolean validate(String password) {
        if (password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*\\d.*")) return false;
        return true;
    }

    @Test
    public void testValidPassword() {
        PasswordValidator pv = new PasswordValidator();
        Assertions.assertTrue(pv.validate("Valid1Password"));
    }

    @Test
    public void testShortPassword() {
        PasswordValidator pv = new PasswordValidator();
        Assertions.assertFalse(pv.validate("Short1"));
    }

    @Test
    public void testNoUppercase() {
        PasswordValidator pv = new PasswordValidator();
        Assertions.assertFalse(pv.validate("nouppercase1"));
    }

    @Test
    public void testNoDigit() {
        PasswordValidator pv = new PasswordValidator();
        Assertions.assertFalse(pv.validate("NoDigitPassword"));
    }
}
