public class Checked_Unchecked {
    static void processData(String input) throws Exception {
        if (input == null) {
            throw new NullPointerException("Input is null");
        }
        if (input.length() < 5) {
            throw new Exception("Input too short");
        }
        System.out.println("Processed: " + input);
    }

    public static void main(String[] args) {
        try {
            processData(null);
        } catch (NullPointerException e) {
            System.out.println("Unchecked Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Checked Exception: " + e.getMessage());
        }
    }
}