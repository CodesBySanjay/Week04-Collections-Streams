import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    public String formatDate(String inputDate) {
        DateTimeFormatter inFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate d = LocalDate.parse(inputDate, inFormat);
        return d.format(outFormat);
    }

    @Test
    public void testValidDate() {
        DateFormatter df = new DateFormatter();
        Assertions.assertEquals("05-05-2025", df.formatDate("2025-05-05"));
    }

    @Test
    public void testInvalidDate() {
        DateFormatter df = new DateFormatter();
        Assertions.assertThrows(DateTimeParseException.class, () -> df.formatDate("invalid-date"));
    }
}
