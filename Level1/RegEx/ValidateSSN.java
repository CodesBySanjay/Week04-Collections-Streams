import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSSN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        Pattern pat = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher mat = pat.matcher(txt);
        if (mat.find()) {
            System.out.println(mat.group() + " is valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
