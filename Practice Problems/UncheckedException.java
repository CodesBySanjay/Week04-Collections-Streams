import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1,num2;
        try {
            System.out.println("Enter first number: ");
            num1 = sc.nextInt();
            System.out.println("Enter second number: ");
            num2 = sc.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Enter numbers");
            return;
        }
        try {
            System.out.println(num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

    }
}
