package TPO_Lab06.ErrorExceptions;

public class NoStudentsException extends Exception {
    // Исключение для отсутствия студентов в группе
    public NoStudentsException(String message) {
        super(message);
    }
}