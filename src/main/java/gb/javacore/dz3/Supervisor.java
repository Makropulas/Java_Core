package gb.javacore.dz3;

public class Supervisor extends Employee {
    public Supervisor(String fullName, String position, String phone, int salary, String birthdate) {
        super(fullName, position, phone, salary, birthdate);
    }

    public static void increasesSalary(Employee[] employees, int age, int increase) {
        for (Employee employee : employees) {
            if (employee.getAge() >= age && !(employee instanceof Supervisor))
                employee.salaryIncrease(increase);
        }
    }
}
