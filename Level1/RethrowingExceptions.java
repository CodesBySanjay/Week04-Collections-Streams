public class RethrowingExceptions {
    static int performDivision(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Denominator is zero");
        }
        return num1 / num2;
    }

    static int calculate(int num1, int num2) {
        try {
            return performDivision(num1, num2);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error in calculate: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            int res = calculate(10, 0);
            System.out.println("Result: " + res);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
