import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCreditCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String rgx = "^(4\\d{15}|5\\d{15})$";
        Pattern pat = Pattern.compile(rgx);
        Matcher mat = pat.matcher(num);
        if (mat.matches()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
