import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

class InsurancePlan {
    private String planNumber;
    private String holderName;
    private LocalDate endDate;

    public InsurancePlan(String planNumber, String holderName, LocalDate endDate) {
        this.planNumber = planNumber;
        this.holderName = holderName;
        this.endDate = endDate;
    }

    public String getPlanNumber() {
        return planNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String toString() {
        return planNumber + " - " + holderName + " - " + endDate;
    }
}

public class InsurancePolicyManagement2 {
    private Map<String, InsurancePlan> byNumber = new HashMap<>();
    private Map<String, InsurancePlan> byOrder = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<InsurancePlan>> byExpiry = new TreeMap<>();

    public void addPlan(InsurancePlan plan) {
        byNumber.put(plan.getPlanNumber(), plan);
        byOrder.put(plan.getPlanNumber(), plan);
        byExpiry.computeIfAbsent(plan.getEndDate(), k -> new ArrayList<>()).add(plan);
    }

    public InsurancePlan getPlanByNumber(String planId) {
        return byNumber.get(planId);
    }

    public List<InsurancePlan> getPlansExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        List<InsurancePlan> expiring = new ArrayList<>();
        for (Map.Entry<LocalDate, List<InsurancePlan>> entry : byExpiry.subMap(today, true, limit, true).entrySet()) {
            expiring.addAll(entry.getValue());
        }
        return expiring;
    }

    public List<InsurancePlan> getPlansByHolder(String name) {
        List<InsurancePlan> plans = new ArrayList<>();
        for (InsurancePlan plan : byOrder.values()) {
            if (plan.getHolderName().equalsIgnoreCase(name)) {
                plans.add(plan);
            }
        }
        return plans;
    }

    public void clearExpiredPlans() {
        LocalDate today = LocalDate.now();
        NavigableMap<LocalDate, List<InsurancePlan>> expiredMap = byExpiry.headMap(today, false);
        List<LocalDate> toRemove = new ArrayList<>(expiredMap.keySet());
        for (LocalDate date : toRemove) {
            List<InsurancePlan> plans = byExpiry.get(date);
            for (InsurancePlan plan : plans) {
                byNumber.remove(plan.getPlanNumber());
                byOrder.remove(plan.getPlanNumber());
            }
            byExpiry.remove(date);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement2 manager = new InsurancePolicyManagement2();
        manager.addPlan(new InsurancePlan("P1001", "Aryan", LocalDate.now().plusDays(10)));
        manager.addPlan(new InsurancePlan("P1002", "Meera", LocalDate.now().plusDays(40)));
        manager.addPlan(new InsurancePlan("P1003", "Aryan", LocalDate.now().minusDays(5)));

        System.out.println("Plan P1002: " + manager.getPlanByNumber("P1002"));
        System.out.println("Expiring soon: " + manager.getPlansExpiringSoon());
        System.out.println("Plans for Aryan: " + manager.getPlansByHolder("Aryan"));
        manager.clearExpiredPlans();
        System.out.println("Remaining plans: " + manager.byOrder.values());
    }
}
