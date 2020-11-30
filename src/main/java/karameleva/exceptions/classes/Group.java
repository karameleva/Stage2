package karameleva.exceptions.classes;

import karameleva.exceptions.exceptions.NoStudentsInTheGroupException;

import java.util.List;

public class Group {
    private String groupName;
    private List<Student> students;

    public Group(String groupName, List<Student> students) throws NoStudentsInTheGroupException {
        if (students.isEmpty()) {
            throw new NoStudentsInTheGroupException("В группе '" + groupName + "' нет студентов");
        }
        this.groupName = groupName;
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return  groupName;
    }
}
