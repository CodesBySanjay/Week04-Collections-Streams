import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateUsername{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        if(Pattern.matches(regex,user)) System.out.println("Valid");
        else System.out.println("Invalid");
        sc.close();
    }
}