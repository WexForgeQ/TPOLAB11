package TPO_Lab06.ErrorExceptions;

public class InvalidGradeException extends Exception {
    // Исключение для недопустимой оценки
    public InvalidGradeException(String message) {
        super(message);
    }
}
