package ErrorsAndExceptions.exceptions;

public class NoSubjectsForStudentException extends Exception {
    public NoSubjectsForStudentException() {
    }

    public NoSubjectsForStudentException(String message) {
        super(message);
    }

    public NoSubjectsForStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSubjectsForStudentException(Throwable cause) {
        super(cause);
    }
}
