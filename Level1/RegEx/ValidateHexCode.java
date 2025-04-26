import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateHexCode {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = "^#[0-9A-Fa-f]{6}$";
        if (Pattern.matches(regex, input)) System.out.println("Valid");
        else System.out.println("Invalid");
        sc.close();
    }
}
