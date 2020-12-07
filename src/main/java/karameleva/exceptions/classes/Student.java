package karameleva.exceptions.classes;

import karameleva.exceptions.exceptions.NoRequiredSubjectException;
import karameleva.exceptions.exceptions.NoSubjectsForStudentException;
import karameleva.exceptions.exceptions.RequiredSubjectDoesNotExistException;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentName;
    private List <Mark> marks;

    public Student(String studentName) {
        this.studentName = studentName;
        this.marks = setMarks();
    }

    public double getAverageScoreForStudent() throws NoSubjectsForStudentException {
        double totalScore = 0;
        for (Mark mark : marks) {
            totalScore += mark.getMark();
        }
        if (totalScore == 0) {
            throw new NoSubjectsForStudentException();
        }
        return totalScore/marks.size();
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }

    public String getStudentName() {
        return studentName;
    }

    public int getMark(String requiredSubject) throws NoSubjectsForStudentException, NoRequiredSubjectException, RequiredSubjectDoesNotExistException {
        if (!Subject.contains(requiredSubject)) {
            throw new RequiredSubjectDoesNotExistException("Required subject '" + requiredSubject + "' doesn't exist");
        }
        if (marks.isEmpty()) {
            throw new NoSubjectsForStudentException("Subjects for student " + studentName + " aren't found");
        }
        for (Mark mark : marks ) {
            if (mark.getSubject().getRealName().toLowerCase().equals(requiredSubject.toLowerCase())) {
                return mark.getMark();
            }
        }
        throw new NoRequiredSubjectException("Subject " + requiredSubject +" for student " + studentName + "wasn't found");
    }

    public List<Mark> getMarks() throws NoSubjectsForStudentException {
        if (marks.isEmpty()) {
            throw new NoSubjectsForStudentException("Subjects for student " + studentName + " aren't found");
        }
        return marks;
    }

    public List<Mark> setMarks() {
        List <Mark> marks = new ArrayList<>();
        return marks;
    }

    @Override
    public String toString() {
        return studentName + marks ;
    }
}
