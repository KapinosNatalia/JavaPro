package ClassStructure;

import java.util.Set;

//- Company
//    - name
//    - Set<Employee>
//    - Set<Department>
public class Company {
    private String name;
    private Set<Employee> employeeSet;
    private Set<Department> departmentSet;

    public Company(String name, Set<Employee> employeeSet, Set<Department> departmentSet) {
        this.name = name;
        this.employeeSet = employeeSet;
        this.departmentSet = departmentSet;
    }

    public String getName() {
        return name;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public Set<Department> getDepartmentSet() {
        return departmentSet;
    }
}
