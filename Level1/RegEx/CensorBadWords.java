import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CensorBadWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String[] badWords = {"damn", "stupid"};
        for (String badWord : badWords) {
            Pattern pattern = Pattern.compile("\\b" + badWord + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(sentence);
            sentence = matcher.replaceAll("****");
        }
        System.out.println(sentence);
    }
}
