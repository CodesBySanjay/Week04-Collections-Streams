import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractRepeatedWords {
    public static void main(String[] args) {
        String txt = "This is is a repeated repeated word test.";
        Pattern pat = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(txt);
        Set<String> seen = new LinkedHashSet<>();
        while (mat.find()) {
            seen.add(mat.group(1).toLowerCase());
        }
        for (String w : seen) {
            System.out.println(w);
        }
    }
}
