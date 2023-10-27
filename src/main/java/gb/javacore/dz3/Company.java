package gb.javacore.dz3;

public class Company {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Ivanov Ivan Ivanovich", "clerk", "+79001111111", 80000, "10.06.1993"),
                new Employee("Petrov Petr Petrovich", "engineer", "+79002222222", 45000, "03.03.1963"),
                new Employee("Pavlov Pavel Pavlovich", "locksmith", "+79003333333", 35000, "08.07.1973"),
                new Employee("Sergeyev Sergey Sergeyevich", "supplier", "+79004444444", 70000, "03.12.1987"),
                new Employee("Deyeva Anna Nikolaevna", "cleaner", "+79005555555", 30000, "12.04.1967"),
                new Supervisor("Alekseyev Aleksey Alekseyevich", "supervisor", "+79006666666", 120000, "13.05.1975")
        };

        printEmployees(employees);
        System.out.println();
        Supervisor.increasesSalary(employees, 45, 5000);
        printEmployees(employees);

        System.out.println();
        System.out.println(employees[0].compare(12, 12, 2000));
        System.out.println(employees[0].compare(employees[1]));
    }

    public static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
