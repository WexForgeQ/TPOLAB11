package TPO_Lab06.Classes;

import TPO_Lab06.Classes.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class StudentTest {

    @Test
    public void testFilterStudentsByFaculty() {
        // Создание списка студентов
        List<Student> students = createStudentList();

        // Факультет для фильтрации
        String faculty = "Факультет 1";

        // Фильтрация студентов по факультету
        List<Student> filteredStudents = Student.filterStudentsByFaculty(students, faculty);

        // Проверка, что все студенты в списке имеют указанный факультет
        for (Student student : filteredStudents) {
            assertEquals(faculty, student.getFaculty());
        }
    }

    @Test
    public void testFilterStudentsByFacultyAndCourse() {
        // Создание списка студентов
        List<Student> students = createStudentList();

        // Факультет и курс для фильтрации
        String faculty = "Факультет 1";
        int course = 1;

        // Фильтрация студентов по факультету и курсу
        List<Student> filteredStudents = Student.filterStudentsByFacultyAndCourse(students, faculty, course);

        // Проверка, что все студенты в списке имеют указанный факультет и курс
        for (Student student : filteredStudents) {
            assertEquals(faculty, student.getFaculty());
            assertEquals(course, student.getCourse());
        }
    }

    @Test
    public void testFilterStudentsByBirthYear() {
        // Создание списка студентов
        List<Student> students = createStudentList();

        // Год для фильтрации
        int year = 1995;

        // Фильтрация студентов по году рождения
        List<Student> filteredStudents = Student.filterStudentsByBirthYear(students, year);

        // Проверка, что все студенты в списке родились после указанного года
        for (Student student : filteredStudents) {
            int birthYear = Integer.parseInt(student.getBirthDate().split("\\.")[2]);
            assertTrue(birthYear > year);
        }
    }

    // Вспомогательный метод для создания списка студентов
    private List<Student> createStudentList() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Иванов", "Иван", "Иванович", "01.01.1990", "Адрес 1", "1111111", "Факультет 1", 1, "Группа 1"));
        students.add(new Student(2, "Петров", "Петр", "Петрович", "02.02.1995", "Адрес 2", "2222222", "Факультет 1", 2, "Группа 2"));
        students.add(new Student(3, "Сидоров", "Сидор", "Сидорович", "03.03.1993", "Адрес 3", "3333333", "Факультет 2", 1, "Группа 1"));
        students.add(new Student(4, "Смирнов", "Алексей", "Алексеевич", "04.04.1992", "Адрес 4", "4444444", "Факультет 2", 2, "Группа 2"));

        return students;
    }
}