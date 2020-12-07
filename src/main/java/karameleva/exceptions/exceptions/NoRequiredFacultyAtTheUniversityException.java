package karameleva.exceptions.exceptions;

public class NoRequiredFacultyAtTheUniversityException extends Exception {
    public NoRequiredFacultyAtTheUniversityException() {
    }

    public NoRequiredFacultyAtTheUniversityException(String message) {
        super(message);
    }

    public NoRequiredFacultyAtTheUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRequiredFacultyAtTheUniversityException(Throwable cause) {
        super(cause);
    }
}
