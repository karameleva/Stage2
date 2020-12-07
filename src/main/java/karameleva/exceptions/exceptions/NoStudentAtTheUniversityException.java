package karameleva.exceptions.exceptions;

public class NoStudentAtTheUniversityException extends Exception {
    public NoStudentAtTheUniversityException() {
    }

    public NoStudentAtTheUniversityException(String message) {
        super(message);
    }

    public NoStudentAtTheUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentAtTheUniversityException(Throwable cause) {
        super(cause);
    }
}
