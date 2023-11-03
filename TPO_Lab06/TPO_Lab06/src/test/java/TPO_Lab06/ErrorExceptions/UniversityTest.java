package TPO_Lab06.ErrorExceptions;

import static org.junit.Assert.*;

import TPO_Lab06.ErrorExceptions.*;
import org.junit.Before;
import org.junit.Test;

public class UniversityTest {
    private University university;

    @Before
    public void setUp() {
        // Создание университета
        university = new University("My University");

        // Создание факультетов
        Faculty faculty1 = new Faculty("Faculty 1");
        Faculty faculty2 = new Faculty("Faculty 2");

        // Добавление факультетов в университет
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        // Создание групп
        Group group1 = new Group("Group 1");
        Group group2 = new Group("Group 2");

        // Добавление групп на факультеты
        faculty1.addGroup(group1);
        faculty2.addGroup(group2);

        // Создание студентов
        Student student1 = new Student("Student 1");
        Student student2 = new Student("Student 2");

        // Добавление студентов в группы
        group1.addStudent(student1);
        group2.addStudent(student2);

        // Создание предметов
        Subject subject1 = new Subject("Subject 1");
        Subject subject2 = new Subject("Subject 2");

        // Добавление предметов студентам
        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student2.addSubject(subject1);
        student2.addSubject(subject2);

        // Добавление оценок
        try {
            subject1.addGrade(8);
            subject1.addGrade(9);
            subject2.addGrade(7);
            subject2.addGrade(6);
        } catch (InvalidGradeException e) {
            fail("Invalid grade: " + e.getMessage());
        }
    }

    @Test
    public void testStudentAverageGrade() {
        try {
            double averageGrade = university.getAverageGrade("Subject 1");
            assertEquals(7.0, averageGrade, 0.01);
        } catch (NoFacultiesException | NoGroupsException | NoStudentsException | NoSubjectsException e) {
            fail("Error: " + e.getMessage());
        }
    }

    @Test
    public void testGroupAverageGrade() {
        try {
            double averageGrade = university.getAverageGrade("Subject 2");
            assertEquals(7.0, averageGrade, 0.01);
        } catch (NoFacultiesException | NoGroupsException | NoStudentsException | NoSubjectsException e) {
            fail("Error: " + e.getMessage());
        }
    }

    @Test
    public void testFacultyAverageGrade() {
        try {
            double averageGrade = university.getAverageGrade("Subject 1");
            assertEquals(7.0, averageGrade, 0.01);
        } catch (NoFacultiesException | NoGroupsException | NoStudentsException | NoSubjectsException e) {
            fail("Error: " + e.getMessage());
        }
    }

    @Test
    public void testUniversityAverageGrade() {
        try {
            double averageGrade = university.getAverageGrade("Subject 2");
            assertEquals(7.0, averageGrade, 0.01);
        } catch (NoFacultiesException | NoGroupsException | NoStudentsException | NoSubjectsException e) {
            fail("Error: " + e.getMessage());
        }
    }

    @Test(expected = NoSubjectsException.class)
    public void testNoSubjectsException() throws NoSubjectsException {
        Student student = new Student("Student");
        student.getAverageGrade();
    }

    @Test(expected = NoStudentsException.class)
    public void testNoStudentsException() throws NoStudentsException, NoSubjectsException {
        Group group = new Group("Group");
        group.getAverageGrade("Subject");
    }

    @Test(expected = NoGroupsException.class)
    public void testNoGroupsException() throws NoGroupsException, NoSubjectsException, NoStudentsException {
        Faculty faculty = new Faculty("Faculty");
        faculty.getAverageGrade("Subject");
    }

    @Test(expected = NoFacultiesException.class)
    public void testNoFacultiesException() throws NoFacultiesException, NoSubjectsException, NoGroupsException, NoStudentsException {
        University emptyUniversity = new University("Empty University");
        emptyUniversity.getAverageGrade("Subject");
    }

    @Test(expected = InvalidGradeException.class)
    public void testInvalidGradeException() throws InvalidGradeException {
        Subject subject = new Subject("Subject");
        subject.addGrade(-1);
    }
}
