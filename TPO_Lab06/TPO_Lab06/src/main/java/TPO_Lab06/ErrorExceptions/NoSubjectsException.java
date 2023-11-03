package TPO_Lab06.ErrorExceptions;

public class NoSubjectsException extends Exception {
    // Исключение для отсутствия предметов у студента
    public NoSubjectsException(String message) {
        super(message);
    }
}
