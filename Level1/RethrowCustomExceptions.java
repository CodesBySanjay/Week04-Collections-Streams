class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}

public class RethrowCustomExceptions {
    static void handleTransaction(String user, double amount) throws TransactionException {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid amount");
            }
            if (amount > 10000) {
                throw new TransactionException("Limit exceeded");
            }
            System.out.println("Transaction successful for " + user + ": $" + amount);
        } catch (IllegalArgumentException | TransactionException e) {
            throw new TransactionException("Transaction error for " + user + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            handleTransaction("Sanjay", 15000);
        } catch (TransactionException e) {
            System.out.println(e.getMessage());
        }
    }
}