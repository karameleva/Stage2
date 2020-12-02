package karameleva.exceptions.exceptions;

public class NoGroupAtTheFacultyException extends Exception {
    public NoGroupAtTheFacultyException() {
    }

    public NoGroupAtTheFacultyException(String message) {
        super(message);
    }

    public NoGroupAtTheFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoGroupAtTheFacultyException(Throwable cause) {
        super(cause);
    }
}
