import java.util.HashSet;
import java.util.Set;

public class InsurancePolicyManagementSystem {
    static class Policy {
        String policyNumber;
        String policyholderName;
        String expiryDate;
        String coverageType;
        double premiumAmount;

        public Policy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Policy policy = (Policy) obj;
            return policyNumber.equals(policy.policyNumber);
        }

        @Override
        public int hashCode() {
            return policyNumber.hashCode();
        }

        @Override
        public String toString() {
            return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry Date: " + expiryDate + ", Coverage Type: " + coverageType + ", Premium: " + premiumAmount;
        }
    }

    public static void main(String[] args) {
        Set<Policy> policies = new HashSet<>();
        policies.add(new Policy("P101", "Sanjay", "2025-05-20", "Health", 500.0));
        policies.add(new Policy("P102", "Patrick", "2025-06-10", "Auto", 600.0));
        policies.add(new Policy("P103", "Charolette", "2025-04-15", "Home", 450.0));

        policies.forEach(System.out::println);
    }
}