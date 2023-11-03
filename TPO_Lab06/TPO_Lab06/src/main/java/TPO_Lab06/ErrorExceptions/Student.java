package TPO_Lab06.ErrorExceptions;

import java.util.List;
import java.util.ArrayList;

public class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public double getAverageGrade() throws NoSubjectsException {
        if (subjects.isEmpty()) {
            throw new NoSubjectsException("No subjects for student: " + name);
        }
        int totalGrades = 0;
        int numSubjects = 0;
        for (Subject subject : subjects) {
            double subjectAverage = subject.getAverageGrade();
            if (subjectAverage > 0) {
                totalGrades += subjectAverage;
                numSubjects++;
            }
        }
        return (double) totalGrades / numSubjects;
    }
}