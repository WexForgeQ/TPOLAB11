package TPO_Lab06.Classes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание массива объектов Student
        List<Student> students = createStudentArray();

        // Вывод списка студентов заданного факультета
        String faculty = "Факультет 1";
        List<Student> studentsByFaculty = Student.filterStudentsByFaculty(students, faculty);
        System.out.println("Студенты факультета " + faculty + ":");
        for (Student student : studentsByFaculty) {
            System.out.println(student.toString());
        }

        System.out.println();

        // Вывод списков студентов для каждого факультета и курса
        System.out.println("Списки студентов для каждого факультета и курса:");
        for (Student student : students) {
            System.out.println(student.toString());
        }

        System.out.println();

        // Вывод списка студентов, родившихся после заданного года
        int birthYear = 2000;
        List<Student> studentsByBirthYear = Student.filterStudentsByBirthYear(students, birthYear);
        System.out.println("Студенты, родившиеся после " + birthYear + " года:");
        for (Student student : studentsByBirthYear) {
            System.out.println(student.toString());
        }

        System.out.println();

        // Вывод списка учебной группы
        String group = "Группа 1";
        List<Student> studentsByGroup = filterStudentsByGroup(students, group);
        System.out.println("Студенты группы " + group + ":");
        for (Student student : studentsByGroup) {
            System.out.println(student.toString());
        }
    }

    public static List<Student> filterStudentsByGroup(List<Student> students, String group) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroup().equals(group)) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public static List<Student> createStudentArray() {
        List<Student> students = new ArrayList<>();

        // Создание и добавление объектов Student в список
        Student student1 = new Student(1, "Иванов", "Иван", "Иванович", "01.01.2000", "Адрес 1",
                "1234567890", "Факультет 1", 1, "Группа 1");
        students.add(student1);

        Student student2 = new Student(2, "Петров", "Петр", "Петрович", "02.02.2001", "Адрес 2",
                "0987654321", "Факультет 2", 1, "Группа 2");
        students.add(student2);

        // Добавьте других студентов по аналогии

        return students;
    }
}