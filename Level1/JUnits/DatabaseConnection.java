import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

public class DatabaseConnection {
    private boolean connected;

    public void connect() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    @BeforeEach
    public void before() {
        connect();
    }

    @AfterEach
    public void after() {
        disconnect();
    }

    @Test
    public void testConnectionIsActive() {
        Assertions.assertTrue(connected);
    }

    @Test
    public void testConnectionAfterDisconnect() {
        disconnect();
        Assertions.assertFalse(connected);
    }
}
