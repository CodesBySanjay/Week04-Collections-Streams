import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCapitalizedWords {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> capWords = new ArrayList<>();
        String input = sc.nextLine();
        Pattern p = Pattern.compile("\\b[A-Z][a-zA-Z]*\\b");
        Matcher m = p.matcher(input);
        while(m.find()){
            capWords.add(m.group());
        }
        System.out.println("Extracted words:"+capWords.toString());
    }
}