package TPO_Lab06.Classes;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String birthDate;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    public Student(int id, String lastName, String firstName, String patronymic, String birthDate, String address,
                   String phone, String faculty, int course, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public String toString() {
        return "Student ID: " + id + "\nName: " + lastName + " " + firstName + " " + patronymic + "\n" +
                "Birth Date: " + birthDate + "\nAddress: " + address + "\nPhone: " + phone + "\n" +
                "Faculty: " + faculty + "\nCourse: " + course + "\nGroup: " + group + "\n";
    }

    public static List<Student> filterStudentsByFaculty(List<Student> students, String faculty) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public static List<Student> filterStudentsByFacultyAndCourse(List<Student> students, String faculty, int course) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getCourse() == course) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public static List<Student> filterStudentsByBirthYear(List<Student> students, int year) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            int birthYear = Integer.parseInt(student.getBirthDate().split("\\.")[2]);
            if (birthYear > year) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public int getCourse() {
        return course;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGroup() {
        return group;
    }
}
