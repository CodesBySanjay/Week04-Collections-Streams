import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) throw new IllegalArgumentException("Invalid username");
        if (email == null || !email.contains("@") || !email.contains(".")) throw new IllegalArgumentException("Invalid email");
        if (password == null || password.length() < 6) throw new IllegalArgumentException("Invalid password");
    }

    @Test
    public void testValidRegistration() {
        UserRegistration u = new UserRegistration();
        u.registerUser("sanjay", "sanjay@mail.com", "secure123");
    }

    @Test
    public void testInvalidEmail() {
        UserRegistration u = new UserRegistration();
        Assertions.assertThrows(IllegalArgumentException.class, () -> u.registerUser("sanjay", "invalidemail", "secure123"));
    }

    @Test
    public void testEmptyUsername() {
        UserRegistration u = new UserRegistration();
        Assertions.assertThrows(IllegalArgumentException.class, () -> u.registerUser("", "mail@domain.com", "secure123"));
    }

    @Test
    public void testShortPassword() {
        UserRegistration u = new UserRegistration();
        Assertions.assertThrows(IllegalArgumentException.class, () -> u.registerUser("sanjay", "mail@domain.com", "123"));
    }
}
