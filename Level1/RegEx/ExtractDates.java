import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDates {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> dates = new ArrayList<>();
        String input = sc.nextLine();
        Pattern p = Pattern.compile("\\b(0[1-9]|[12][0-9]|3[01])/(0[0-9]|1[0-2])/\\d{4}\\b");
        Matcher m = p.matcher(input);
        while(m.find()){
            dates.add(m.group());
        }
        System.out.println("Extracted dates:"+dates.toString());
    }
}