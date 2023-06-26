package ClassStructure;

import java.util.*;

public class Info {
    /*
    * - Info
    - Map<Position, List<String>>
    - checker() - на вход сотруника, на выходе String в зависимости от позишн
    - avgSalaryDep() - на вход Set<Employee>, Department, на выход средняя зп по департаменту
    - maxSalary() - на вход Set<Employee>, Department, на выход max зп по департаменту + у кого такая зп(имя)
    - minSalary() - на вход Set<Employee>, Department, на выход min зп по департаменту + у кого такая зп(имя)
    - getPromotion() - на вход сотрудника. в методе - засетить переход на одну позицию выше и зп на 25% больше.
    * */
    //Map<Position, List<String>>

    public static void main(String[] args) {
        Company company = createCompany();
        for (Employee employee: company.getEmployeeSet()) {
            System.out.println(employee.getName() + ", position: " + checker(employee));
        }
        System.out.println("Средняя ЗП по Бухгалтерии: " + avgSalaryDep(company.getEmployeeSet(), Department.ACCOUNTING));
        System.out.println("Средняя ЗП по Охране: " + avgSalaryDep(company.getEmployeeSet(), Department.SECURITY));
        System.out.println("Максимальная ЗП по Охране: " + maxSalary(company.getEmployeeSet(), Department.SECURITY));
        System.out.println("Минимальная ЗП по Охране: " + minSalary(company.getEmployeeSet(), Department.SECURITY));
        // увеличим ЗП всем сотрудникам на 25%
        Iterator<Employee> employeeIterator = company.getEmployeeSet().iterator();
        while (employeeIterator.hasNext()) {
            getPromotion(employeeIterator.next(), 25);
        }
    }

    public static String checker(Employee employee) {
        return employee.getPosition().name();
    }

    public static double avgSalaryDep(Set<Employee> employeeSet, Department department) {
        double sum = 0;
        int count = 0;
        for (Employee employee: employeeSet) {
            if (department.equals(employee.getDepartment())) {
                sum += employee.getSalary();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        else {
            return sum/count;
        }
    }

    public static Map<String, Double> maxSalary(Set<Employee> employeeSet, Department department) {
        double max = 0.0;
        String name = "";
        for (Employee employee: employeeSet) {
            if (department.equals(employee.getDepartment()) && max < employee.getSalary()) {
                max = employee.getSalary();
                name = employee.getName();
            }
        }
        Map<String, Double> map = new HashMap<>();
        map.put(name, max);
        return map;
    }

    public static Map<String, Double> minSalary(Set<Employee> employeeSet, Department department) {
        double min = Integer.MAX_VALUE;
        String name = "";
        for (Employee employee: employeeSet) {
            if (department.equals(employee.getDepartment()) && min > employee.getSalary()) {
                min = employee.getSalary();
                name = employee.getName();
            }
        }
        Map<String, Double> map = new HashMap<>();
        map.put(name, min);
        return map;
    }

    public static void getPromotion(Employee employee, int percent) {
        employee.setPosition(Position.getNewPosition(employee.getPosition()));
        employee.setSalary(employee.getSalary()*(1 + (double)percent/100));
        System.out.println(employee.getName() + " новая должность: " + employee.getPosition() + " новая ЗП: " + employee.getSalary());
    }

    public static Company createCompany() {
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(new Employee("Ivan Ivanov", Department.ADMINISTRATION, Position.DIRECTOR, 10000));
        employeeSet.add(new Employee("Olga Petrenko", Department.ACCOUNTING, Position.CHIEF_ACCOUNTANT, 9000));
        employeeSet.add(new Employee("Anna Tereshenko", Department.ACCOUNTING, Position.ACCOUNTANT, 8000));
        employeeSet.add(new Employee("Andrey Sidorov", Department.IT, Position.TEAM_LEAD, 9000));
        employeeSet.add(new Employee("Igor Igorov", Department.IT, Position.DEVELOPER, 8000));
        employeeSet.add(new Employee("Stepan Stepanov", Department.SALES, Position.SALES_MANAGER, 7000));
        employeeSet.add(new Employee("Oleg Olegov", Department.SECURITY, Position.SECURITY_GUARD, 5000));
        employeeSet.add(new Employee("Dmitriy Olegov", Department.SECURITY, Position.SECURITY_GUARD, 3000));
        employeeSet.add(new Employee("Viktor Olegov", Department.SECURITY, Position.SECURITY_GUARD, 4500.50));
        employeeSet.add(new Employee("Kirill Olegov", Department.SECURITY, Position.SECURITY_GUARD, 3800));

        Set<Department> departmentSet = new HashSet<>();
        departmentSet.add(Department.ADMINISTRATION);
        departmentSet.add(Department.ACCOUNTING);
        departmentSet.add(Department.IT);
        departmentSet.add(Department.SALES);
        departmentSet.add(Department.SECURITY);

        return new Company("myCompany", employeeSet, departmentSet);
    }
}
