import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLanguageNames {
    public static void main(String[] args) {
        String txt = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        Pattern pat = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b");
        Matcher mat = pat.matcher(txt);
        List<String> langs = new ArrayList<>();
        while (mat.find()) {
            langs.add(mat.group());
        }
        for (String lang : langs) {
            System.out.println(lang);
        }
    }
}
