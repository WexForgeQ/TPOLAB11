package TPO_Lab06.ErrorExceptions;

public class NoGroupsException extends Exception {
    // Исключение для отсутствия групп на факультете
    public NoGroupsException(String message) {
        super(message);
    }
}