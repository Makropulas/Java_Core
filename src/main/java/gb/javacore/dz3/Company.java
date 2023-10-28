package gb.javacore.dz3;

import java.util.Arrays;

public class Company {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Ivanov Ivan Ivanovich", "clerk", "+79001111111", 80000, "10.06.1993"),
                new Employee("Petrov Petr Petrovich", "engineer", "+79002222222", 45000, "03.03.1963"),
                new Employee("Pavlov Pavel Pavlovich", "locksmith", "+79003333333", 45000, "08.07.1973"),
                new Employee("Sergeyev Sergey Sergeyevich", "supplier", "+79004444444", 70000, "03.12.1987"),
                new Employee("Deyeva Anna Nikolaevna", "cleaner", "+79005555555", 45000, "12.04.1967"),
                new Supervisor("Alekseyev Aleksey Alekseyevich", "supervisor", "+79006666666", 120000, "13.05.1975")
        };

        printEmployees(employees);
        System.out.println();
        Supervisor.increasesSalary(employees, 45, 5000);
        printEmployees(employees);

        System.out.println();

        Arrays.sort(employees, new Employee.SalaryComparator().thenComparing(new Employee.ReverseAgeComparator()));
        printEmployees(employees);
        System.out.println(employees[0].compare(12, 12, 2000));
    }

    public static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
