import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmail {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> emails = new ArrayList<>();
        String input = sc.nextLine();
        Pattern p = Pattern.compile("[a-zA-Z0-9+-_.]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher m = p.matcher(input);
        while(m.find()){
            emails.add(m.group());
        }
        System.out.println("Extracted emails:"+emails.toString());
    }
}
