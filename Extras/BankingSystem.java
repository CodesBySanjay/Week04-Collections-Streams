import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BankingSystem {
    private HashMap<Integer, Double> accounts;
    private Queue<Integer> withdrawalQueue;

    public BankingSystem() {
        accounts = new HashMap<>();
        withdrawalQueue = new LinkedList<>();
    }

    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            double balance = accounts.get(accountNumber);
            if (balance >= amount) {
                accounts.put(accountNumber, balance - amount);
                System.out.println("Withdrawal of " + amount + " processed for account " + accountNumber);
            } else {
                System.out.println("Insufficient balance for account " + accountNumber);
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            double balance = entry.getValue();
            sortedAccounts.putIfAbsent(balance, new ArrayList<>());
            sortedAccounts.get(balance).add(entry.getKey());
        }
        for (Map.Entry<Double, List<Integer>> entry : sortedAccounts.entrySet()) {
            double balance = entry.getKey();
            List<Integer> accountNumbers = entry.getValue();
            for (int accountNumber : accountNumbers) {
                System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
        system.createAccount(101, 5000.0);
        system.createAccount(102, 3000.0);
        system.createAccount(103, 7000.0);

        system.requestWithdrawal(101);
        system.requestWithdrawal(103);
        system.processWithdrawals(1000.0);

        System.out.println("\nAccounts Sorted by Balance:");
        system.displayAccountsSortedByBalance();
    }
}
