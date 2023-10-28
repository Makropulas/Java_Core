package gb.javacore.dz3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private String fullName;
    private String position;
    private String phone;
    private int salary;
    private LocalDate birthdate;

    public Employee(String fullName, String position, String phone, int salary, String birthdate) {
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthdate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }

    public String getBirthdate() {
        return String.format("%d.%d.%d", birthdate.getDayOfMonth(), birthdate.getMonthValue(), birthdate.getYear());
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public void salaryIncrease(int increase) {
        this.salary += increase;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s | Position: %s | Phone: %s | Salary: %d | Age: %d",
                getFullName(), getPosition(), getPhone(), getSalary(), getAge());
    }

    public int compare(int dd, int mm, int yyyy) {
        int employee = birthdate.getDayOfMonth() + (birthdate.getMonthValue() << 6) + (birthdate.getYear() << 11);
        int comparisonDate = dd + (mm << 6) + (yyyy << 11);
        return employee - comparisonDate;
    }

    @Override
    public int compareTo(Employee employee) {
        return employee.birthdate.compareTo(birthdate);
    }

    static class ReverseAgeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee emp1, Employee emp2) {
            return emp1.birthdate.compareTo(emp2.birthdate);
        }
    }

    static class SalaryComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee emp1, Employee emp2) {
            return Integer.compare(emp1.salary, emp2.salary);
        }
    }
}
