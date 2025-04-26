import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinks {
    public static void main(String[] args) {
        String txt = "Visit https://www.google.com and http://example.org for more info.";
        Pattern pat = Pattern.compile("https?://\\S+");
        Matcher mat = pat.matcher(txt);
        List<String> found = new ArrayList<>();
        while (mat.find()) {
            found.add(mat.group());
        }
        for (String link : found) {
            System.out.println(link);
        }
    }
}
