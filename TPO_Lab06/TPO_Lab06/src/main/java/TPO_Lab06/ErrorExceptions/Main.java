package TPO_Lab06.ErrorExceptions;

public class Main {
    public static void main(String[] args) {
        // Создание университета
        University university = new University("My University");

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
            System.out.println("Invalid grade: " + e.getMessage());
        }

        // Расчет среднего балла
        try {
            double studentAverage = student1.getAverageGrade();
            System.out.println("Student 1 average grade: " + studentAverage);

            double groupAverage = group1.getAverageGrade("Subject 1");
            System.out.println("Group 1 average grade for Subject 1: " + groupAverage);

            double facultyAverage = faculty1.getAverageGrade("Subject 2");
            System.out.println("Faculty 1 average grade for Subject 2: " + facultyAverage);

            double universityAverage = university.getAverageGrade("Subject 1");
            System.out.println("University average grade for Subject 1: " + universityAverage);
        } catch (NoSubjectsException | NoStudentsException | NoGroupsException | NoFacultiesException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}