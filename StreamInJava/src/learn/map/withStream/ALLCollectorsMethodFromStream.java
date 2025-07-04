package learn.map.withStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ALLCollectorsMethodFromStream {

    public void CollectorsMethod() {
        List<Employee2> Employee2s = Arrays.asList(
                new Employee2("Alice", "HR", 50000),
                new Employee2("Bob", "IT", 60000),
                new Employee2("Charlie", "IT", 70000),
                new Employee2("David", "HR", 55000),
                new Employee2("Eve", "Finance", 75000),
                new Employee2("Frank", "IT", 80000)
        );

        // 1. toList()
        List<Employee2> Employee2List = Employee2s.stream().collect(Collectors.toList());
        System.out.println("List: " + Employee2List);

        // 2. toSet()
        Set<Employee2> Employee2Set = Employee2s.stream().collect(Collectors.toSet());
        System.out.println("Set: " + Employee2Set);

        // 3. toMap()
        Map<String, Double> Employee2Map = Employee2s.stream()
                .collect(Collectors.toMap(Employee2::getName, Employee2::getSalary));
        System.out.println("Map learn: " + Employee2Map);


        // 3. toMap()
        Map<String, Double> Employee2MapNew = Employee2s.stream()
                .collect(Collectors.toMap(e->e.getName(), e -> e.getSalary()));
        System.out.println("Map Employee2MapNew: " + Employee2MapNew);


        // 4. toCollection()
        LinkedList<Employee2> Employee2LinkedList = Employee2s.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("LinkedList: " + Employee2LinkedList);


        // 5. joining()
        String names = Employee2s.stream()
                .map(Employee2::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Joined Names: " + names);

        // 6. counting()
        long count = Employee2s.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        // 7. summarizingDouble()
        DoubleSummaryStatistics salaryStats = Employee2s.stream()
                .collect(Collectors.summarizingDouble(Employee2::getSalary));
        System.out.println("Salary Stats: " + salaryStats);

        // 8. averagingDouble()
        double averageSalary = Employee2s.stream()
                .collect(Collectors.averagingDouble(Employee2::getSalary));
        System.out.println("Average Salary: " + averageSalary);

        // 9. summingDouble()
        double totalSalary = Employee2s.stream()
                .collect(Collectors.summingDouble(Employee2::getSalary));
        System.out.println("Total Salary: " + totalSalary);

        // 10. maxBy()
        Optional<Employee2> highestPaid = Employee2s.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee2::getSalary)));
        System.out.println("Highest Paid: " + highestPaid.orElse(null));


        // 11. groupingBy()
        Map<String, List<Employee2>> Employee2sByDept = Employee2s.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment));
        System.out.println("Employee2s by Department: " + Employee2sByDept);

        // 12. partitioningBy()
        Map<Boolean, List<Employee2>> partitionedByHighSalary = Employee2s.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 60000));
        System.out.println("Partitioned by High Salary: " + partitionedByHighSalary);

        // 13. reducing()
        Optional<Double> totalSalaryReducing = Employee2s.stream()
                .map(Employee2::getSalary)
                .collect(Collectors.reducing(Double::sum));
        System.out.println("Total Salary (Reducing): " + totalSalaryReducing.orElse(0.0));

        // 14. mapping()
        List<String> Employee2Names = Employee2s.stream()
                .collect(Collectors.mapping(Employee2::getName, Collectors.toList()));
        System.out.println("Employee2 Names: " + Employee2Names);

        // 15. collectingAndThen()
        List<Employee2> unmodifiableEmployee2List = Employee2s.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println("Unmodifiable List: " + unmodifiableEmployee2List);
    }




}

 class Employee2 {
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee2(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

     public Employee2(String name) {
         this.name = name;
     }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
