import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeDataProcessing {
    public static Map<String, Double> run(List<Employee> emps) {
        return emps.stream()
            .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
            .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));
    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

