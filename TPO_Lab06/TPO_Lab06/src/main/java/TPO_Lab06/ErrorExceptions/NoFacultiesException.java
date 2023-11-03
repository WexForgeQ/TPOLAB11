package TPO_Lab06.ErrorExceptions;

public class NoFacultiesException extends Exception {
    // Исключение для отсутствия факультетов в университете
    public NoFacultiesException(String message) {
        super(message);
    }
}