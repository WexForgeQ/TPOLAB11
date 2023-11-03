package TPO_Lab06.ErrorExceptions;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groups;

    public Faculty(String name) {
        this.name = name;
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public double getAverageGrade(String subjectName) throws NoGroupsException, NoStudentsException, NoSubjectsException {
        if (groups.isEmpty()) {
            throw new NoGroupsException("No groups in faculty: " + name);
        }
        int totalGrades = 0;
        int numGroups = 0;
        for (Group group : groups) {
            double groupAverage = group.getAverageGrade(subjectName);
            if (groupAverage > 0) {
                totalGrades += groupAverage;
                numGroups++;
            }
        }
        return (double) totalGrades / numGroups;
    }
}