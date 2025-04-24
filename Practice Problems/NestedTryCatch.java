import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40};
        int idx = sc.nextInt();
        int div = sc.nextInt();

        try {
            try {
                int res = arr[idx] / div;
                System.out.println("Result: " + res);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }

        sc.close();
    }
}
