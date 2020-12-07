package karameleva.exceptions.exceptions;

public class NoRequiredGroupException extends Exception {
    public NoRequiredGroupException() {
    }

    public NoRequiredGroupException(String message) {
        super(message);
    }

    public NoRequiredGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRequiredGroupException(Throwable cause) {
        super(cause);
    }
}
