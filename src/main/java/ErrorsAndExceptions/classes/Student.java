package ErrorsAndExceptions.classes;

import ErrorsAndExceptions.exceptions.NoSubjectsForStudentException;

import java.util.List;

public class Student {
    private String studentName;
    private List <Mark> marks;

    public Student(String studentName, List<Mark> marks) throws NoSubjectsForStudentException {
        if (marks.isEmpty()) {
            throw new NoSubjectsForStudentException("У студента " + studentName + " нет предметов");
        }
        this.studentName = studentName;
        this.marks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return studentName ;
    }
}
