package TPO_Lab06.ErrorExceptions;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public double getAverageGrade(String subjectName) throws NoFacultiesException, NoGroupsException, NoStudentsException, NoSubjectsException {
        if (faculties.isEmpty()) {
            throw new NoFacultiesException("No faculties in university: " + name);
        }
        int totalGrades = 0;
        int numFaculties = 0;
        for (Faculty faculty : faculties) {
            double facultyAverage = faculty.getAverageGrade(subjectName);
            if (facultyAverage > 0) {
                totalGrades += facultyAverage;
                numFaculties++;
            }
        }
        return (double) totalGrades / numFaculties;
    }
}