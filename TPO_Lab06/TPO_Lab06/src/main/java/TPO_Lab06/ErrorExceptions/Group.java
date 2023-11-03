package TPO_Lab06.ErrorExceptions;

import java.util.List;
import java.util.ArrayList;

public class Group {
    private String name;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double getAverageGrade(String subjectName) throws NoStudentsException, NoSubjectsException {
        if (students.isEmpty()) {
            throw new NoStudentsException("No students in group: " + name);
        }
        int totalGrades = 0;
        int numStudents = 0;
        for (Student student : students) {
            double studentAverage = student.getAverageGrade();
            if (studentAverage > 0) {
                totalGrades += studentAverage;
                numStudents++;
            }
        }
        return (double) totalGrades / numStudents;
    }
}