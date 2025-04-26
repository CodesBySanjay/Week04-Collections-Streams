import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class PerformanceTesting {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(1000);
        return "done";
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testTimeout() throws InterruptedException {
        longRunningTask();
    }
}
