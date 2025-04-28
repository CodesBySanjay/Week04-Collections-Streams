import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    String claimDate;
    String status;

    Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class PolicyClaimSummary {
    String policyNumber;
    double totalClaimAmount;
    double averageClaimAmount;

    PolicyClaimSummary(String policyNumber, double totalClaimAmount, double averageClaimAmount) {
        this.policyNumber = policyNumber;
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }
}

public class ClaimsAnalysis {
    public static List<PolicyClaimSummary> analyze(List<Claim> claims) {
        Map<String, List<Claim>> grouped = claims.stream()
            .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
            .collect(Collectors.groupingBy(c -> c.policyNumber));

        return grouped.entrySet().stream()
            .map(e -> {
                String p = e.getKey();
                List<Claim> cs = e.getValue();
                double total = cs.stream().mapToDouble(c -> c.claimAmount).sum();
                double avg = total / cs.size();
                return new PolicyClaimSummary(p, total, avg);
            })
            .sorted(Comparator.comparingDouble(s -> -s.totalClaimAmount))
            .limit(3)
            .collect(Collectors.toList());
    }
}
