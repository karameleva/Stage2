package karameleva.exceptions.exceptions;

public class RequiredSubjectDoesNotExistException extends Exception {
    public RequiredSubjectDoesNotExistException() {
    }

    public RequiredSubjectDoesNotExistException(String message) {
        super(message);
    }

    public RequiredSubjectDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequiredSubjectDoesNotExistException(Throwable cause) {
        super(cause);
    }
}
