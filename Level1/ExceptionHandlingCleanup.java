public class ExceptionHandlingCleanup {
    static class Connection {
        void open() {
            System.out.println("Connection opened");
        }

        void close() {
            System.out.println("Connection closed");
        }

        void execute(String command) {
            if (command == null) {
                throw new IllegalArgumentException("Command cannot be null");
            }
            System.out.println("Executing: " + command);
        }
    }

    public static void main(String[] args) {
        Connection conn = new Connection();
        try {
            conn.open();
            conn.execute(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            conn.close();
        }
    }
}