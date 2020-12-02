package karameleva.exceptions.classes;

import karameleva.exceptions.exceptions.NoSubjectsForStudentException;

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

    public double getAverageScoreForStudent() {
        double totalScore = 0;
        for (Mark mark : marks) {
            totalScore += mark.getMark();
        }
        return totalScore/marks.size();
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
