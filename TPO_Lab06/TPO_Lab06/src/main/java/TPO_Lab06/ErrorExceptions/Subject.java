package TPO_Lab06.ErrorExceptions;

import java.util.List;
import java.util.ArrayList;
public class Subject {
    private String name;
    private List<Integer> grades;

    public Subject(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) throws InvalidGradeException {
        if (grade < 0 || grade > 10) {
            throw new InvalidGradeException("Invalid grade: " + grade);
        }
        grades.add(grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}