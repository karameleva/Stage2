package karameleva.exceptions.classes;

import karameleva.exceptions.exceptions.NoRequiredSubjectException;
import karameleva.exceptions.exceptions.NoStudentsInTheGroupException;
import karameleva.exceptions.exceptions.NoSubjectsForStudentException;
import karameleva.exceptions.exceptions.RequiredSubjectDoesNotExistException;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<Student> students;

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = setStudents();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Student> getStudents() throws NoStudentsInTheGroupException{
        if (students.isEmpty()) {
            throw new NoStudentsInTheGroupException("At group '" + groupName + "' students aren't found");
        }
        return students;
    }

    public Student getStudent(String studentName) throws NoStudentsInTheGroupException {
        if (students.isEmpty()) {
            throw new NoStudentsInTheGroupException("At group '" + groupName + "' students aren't found");
        }
        for (Student student : students) {
            if (student.getStudentName().toLowerCase().equals(studentName.toLowerCase())) {
                return student;
            }
        }
        return null;
    }

    public double getAverageScoreForSubjectAtGroup(String requiredSubject) throws NoStudentsInTheGroupException, NoSubjectsForStudentException, NoRequiredSubjectException, RequiredSubjectDoesNotExistException {
        if (students.isEmpty()) {
            throw new NoStudentsInTheGroupException("At group '" + groupName + "' students aren't found");
        }
        double totalScore = 0;
        int mark;
        int amount = 0;
        for (Student student : students){
            try {
                if ((mark = student.getMark(requiredSubject)) != 0){
                    totalScore += mark;
                    amount ++;
                }
            }catch (NoRequiredSubjectException e) {

            }
        }
        if (amount == 0) {
            throw new NoRequiredSubjectException("Subject " + requiredSubject +" for group " + groupName + " wasn't found");
        }
        return totalScore/amount;
    }

    public List<Student> setStudents() {
       List <Student> students = new ArrayList<>();
       return students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", students=" + students +
                '}';
    }
}
