package karameleva.exceptions.classes;

import karameleva.exceptions.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String facultyName;
    private List<Group> groups;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
        this.groups = setGroups();
    }

    public Student getStudentAtTheFaculty(String studentName) throws NoStudentsInTheGroupException {
        for (Group group : groups) {
            Student student = group.getStudent(studentName);
            if (student != null) {
                return student;
            }
        }
        return null;
    }

    public Group getGroup (String requiredGroupName) throws NoGroupsAtTheFacultyException, NoRequiredGroupException {
        if (groups.isEmpty()) {
            throw new NoGroupsAtTheFacultyException("At faculty " + facultyName + "groups aren't found");
        }
        for (Group group : groups) {
            if (group.getGroupName().toLowerCase().equals(requiredGroupName.toLowerCase())) {
                return group;
            }
        }
        throw new NoRequiredGroupException("Group " + requiredGroupName + " at the faculty " + facultyName + " wasn't found");
    }

    public double getAverageScoreForSubjectAtFaculty(String requiredSubject) throws NoStudentsInTheGroupException, NoGroupsAtTheFacultyException, NoSubjectsForStudentException, RequiredSubjectDoesNotExistException, NoRequiredSubjectException {
        if (groups.isEmpty()) {
            throw new NoGroupsAtTheFacultyException("At faculty " + facultyName + "groups aren't found");
        }
        double total = 0;
        int amount = 0;
        for (Group group : groups){
            try {
                total += group.getAverageScoreForSubjectAtGroup(requiredSubject);
                amount ++;
            } catch (NoRequiredSubjectException e) { }
        }
        if (amount != 0) {
            return total/amount;
        }
        throw new NoRequiredSubjectException("Subject '" + requiredSubject + " at the faculty '" + facultyName + "' isn't found");
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public String getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroups() throws NoGroupsAtTheFacultyException {
        if (groups.isEmpty()) {
            throw new NoGroupsAtTheFacultyException("На факультете '" + facultyName + "' нет групп");
        }
        return groups;
    }

    public List<Group> setGroups() {
        List<Group> groups = new ArrayList<>();
        return groups;
    }

    @Override
    public String toString() {
        return  facultyName;
    }
}