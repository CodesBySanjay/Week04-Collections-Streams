import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StringUtils {
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public boolean isPalindrome(String s) {
        String rev = reverse(s);
        return s.equals(rev);
    }

    public String toUpperCase(String s) {
        return s.toUpperCase();
    }

    @Test
    public void testReverse() {
        String val = reverse("hello");
        Assertions.assertEquals("olleh", val);
    }

    @Test
    public void testIsPalindromeTrue() {
        boolean val = isPalindrome("madam");
        Assertions.assertTrue(val);
    }

    @Test
    public void testIsPalindromeFalse() {
        boolean val = isPalindrome("world");
        Assertions.assertFalse(val);
    }

    @Test
    public void testToUpperCase() {
        String val = toUpperCase("java");
        Assertions.assertEquals("JAVA", val);
    }
}
