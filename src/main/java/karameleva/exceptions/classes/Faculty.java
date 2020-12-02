package karameleva.exceptions.classes;

import karameleva.exceptions.exceptions.*;

import java.util.List;

public class Faculty {
    private String facultyName;
    private List<Group> groups;

    public Faculty(String facultyName, List<Group> groups) throws NoGroupsAtTheFacultyException {
        if (groups.isEmpty()) {
            throw new NoGroupsAtTheFacultyException("На факультете '" + facultyName + "' нет групп");
        }
        this.facultyName = facultyName;
        this.groups = groups;
    }

    public double getAverageScoreForSubjectInGroupAtFaculty(Subject subject, Group requiredGroup) throws NoGroupAtTheFacultyException {
        double totalScore = 0;
        int amountOfMarks = 0;
        if (groups.contains(requiredGroup)) {
            for (Group group : groups) {
                if (group.equals(requiredGroup)) {
                    for (Student student : group.getStudents()) {
                        for (Mark mark : student.getMarks()) {
                            if (mark.getSubject().equals(subject)) {
                                totalScore += mark.getMark();
                                amountOfMarks ++;
                            }
                        }
                    }
                }
            }
        }else {
            throw new NoGroupAtTheFacultyException("На факультете '" + facultyName + "' нет группы " + requiredGroup.getGroupName());
        }
        return totalScore/amountOfMarks;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return  facultyName;
    }
}