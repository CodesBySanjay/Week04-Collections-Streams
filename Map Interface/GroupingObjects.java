import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    String name;
    String department;
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    public String toString() {
        return name;
    }
}
public class GroupingObjects {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );
        Map<String, List<Employee>> departmentMap = new HashMap<>();
        for (Employee emp : employees) {
            departmentMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }
        for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}