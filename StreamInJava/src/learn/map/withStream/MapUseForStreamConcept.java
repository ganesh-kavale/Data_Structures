package learn.map.withStream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *
 *
 * We will create 5 elements with 4 attributes
 *
 * We have a list of those 5 elements
 *
 * if length of name is more than 5.
 *
 * We map the data for 2 attributes only and print this new data after mapping
 *
 *
 * */
public class MapUseForStreamConcept {

    public void solution() {
        
        List<Employee> employeeList= Arrays.asList(
                
                new Employee(1,"Krishna","Krishna","all"),
                new Employee(2,"Ganesh","Ganesh","v"),
                new Employee(3,"Balramm","Balramm","all"),
                new Employee(4,"Rudra","Rudra","all"),
                new Employee(5,"aryan","aryan","v")
                
        );


        Stream<Employee> eStream = employeeList.stream();

        eStream.filter(ele->ele.getName().length()>5)
                .map(e -> getDataWithTwoAttributes(e))
                .forEach(System.out::println);





    }

    private String getDataWithTwoAttributes(Employee e) {

        return e.getId() + " " + e.getName();
    }


}

class Employee {

    int id;

    String code;

    String name;

    String source;

    public Employee(int id, String code, String name, String source) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}