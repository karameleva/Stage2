package karameleva.exceptions.exceptions;

public class NoRequiredSubjectException extends Exception {
    public NoRequiredSubjectException() {
    }

    public NoRequiredSubjectException(String message) {
        super(message);
    }

    public NoRequiredSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRequiredSubjectException(Throwable cause) {
        super(cause);
    }
}
