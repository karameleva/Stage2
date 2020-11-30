package karameleva.exceptions.exceptions;

public class NoStudentsInTheGroupException extends Exception {
    public NoStudentsInTheGroupException() {
    }

    public NoStudentsInTheGroupException(String message) {
        super(message);
    }

    public NoStudentsInTheGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentsInTheGroupException(Throwable cause) {
        super(cause);
    }
}
