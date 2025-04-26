import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrencyValues {
    public static void main(String[] args) {
        String txt = "The price is $45.99, and the discount is 10.50.";
        Pattern pat = Pattern.compile("\\$?\\d+\\.\\d{2}");
        Matcher mat = pat.matcher(txt);
        List<String> vals = new ArrayList<>();
        while (mat.find()) {
            vals.add(mat.group());
        }
        for (String v : vals) {
            System.out.println(v);
        }
    }
}
