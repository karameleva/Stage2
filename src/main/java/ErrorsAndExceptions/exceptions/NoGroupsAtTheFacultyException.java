package ErrorsAndExceptions.exceptions;

public class NoGroupsAtTheFacultyException extends Exception {
    public NoGroupsAtTheFacultyException() {
    }

    public NoGroupsAtTheFacultyException(String message) {
        super(message);
    }

    public NoGroupsAtTheFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoGroupsAtTheFacultyException(Throwable cause) {
        super(cause);
    }
}
