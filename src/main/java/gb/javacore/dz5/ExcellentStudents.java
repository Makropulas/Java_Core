package gb.javacore.dz5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExcellentStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Павел", Arrays.asList(4.2, 4.3, 4.5), "Математика"),
                new Student("Павел", Arrays.asList(4.2, 4.3, 4.5), "Информатика"),
                new Student("Сергей", Arrays.asList(4.9, 4.8, 4.5), "Математика"),
                new Student("Сергей", Arrays.asList(4.5, 4.5, 4.5), "Информатика"),
                new Student("Иван", Arrays.asList(4.5, 4.7, 4.5), "Информатика"),
                new Student("Виктор", Arrays.asList(5.0, 4.4, 4.5), "Информатика"),
                new Student("Андрей", Arrays.asList(4.7, 4.7, 4.9), "Информатика"),
                new Student("Антон", Arrays.asList(4.9, 4.9, 4.9), "Информатика"),
                new Student("Данил", Arrays.asList(4.8, 4.8, 4.9), "Информатика"),
                new Student("Денис", Arrays.asList(4.9, 4.7, 4.9), "Информатика"),
                new Student("Марк", Arrays.asList(4.5, 4.7, 4.8), "Информатика"),
                new Student("Пётр", Arrays.asList(4.7, 4.7, 4.3), "Информатика")
        );

        List<Student> result = students.stream()
                .filter(s -> s.getSpecialty().equals("Информатика") && s.getAverageGrade() > 4.5)
                .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                .limit(5)
                .toList();

        result.forEach(System.out::println);
    }
}

class Student {
    private String name;
    private List<Double> grades;
    private String specialty;

    public Student(String name, List<Double> grades, String specialty) {
        this.name = name;
        this.grades = grades;
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    /**
     * Метод получения среднего балла
     */
    public double getAverageGrade() {
        return grades.stream()
                .mapToDouble(grade -> grade)
                .average()
                .orElse(-1);
    }

    @Override
    public String toString() {
        return String.format("Имя: %-7s| специальность: %-12s| средний балл: %.2f",
                name, specialty, getAverageGrade());
    }
}
