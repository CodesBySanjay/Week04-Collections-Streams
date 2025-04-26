import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateLicensePlateNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = "^[A-Z]{2}\\d{4}$";
        if (Pattern.matches(regex, input)) System.out.println("Valid");
        else System.out.println("Invalid");
        sc.close();
    }
}
