import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudAlert {
    String policyNumber;
    int fraudCount;
    double totalFraudAmount;

    FraudAlert(String policyNumber, int fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }
}

public class FraudDetection {
    public static List<FraudAlert> detect(List<Transaction> txns) {
        Map<String, List<Transaction>> grouped = txns.stream()
            .filter(t -> t.isFraudulent && t.amount > 10000)
            .collect(Collectors.groupingBy(t -> t.policyNumber));

        return grouped.entrySet().stream()
            .map(e -> {
                String p = e.getKey();
                List<Transaction> ts = e.getValue();
                int count = ts.size();
                double total = ts.stream().mapToDouble(t -> t.amount).sum();
                return new FraudAlert(p, count, total);
            })
            .filter(f -> f.fraudCount > 5 || f.totalFraudAmount > 50000)
            .collect(Collectors.toList());
    }
}
