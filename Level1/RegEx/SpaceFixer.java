import java.util.Scanner;
import java.util.regex.Pattern;

public class SpaceFixer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        String fixed = Pattern.compile("\\s+").matcher(txt).replaceAll(" ");
        System.out.println(fixed);
    }
}