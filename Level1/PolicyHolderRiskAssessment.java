import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }
}

public class PolicyHolderRiskAssessment {
    public static Map<String, List<RiskAssessment>> assess(List<PolicyHolder> holders) {
        return holders.stream()
            .filter(h -> h.policyType.equals("Life") && h.age > 60)
            .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
            .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore))
            .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));
    }
}
