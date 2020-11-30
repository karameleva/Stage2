package karameleva.exceptions.classes;

import karameleva.exceptions.exceptions.NoGroupsAtTheFacultyException;

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

    public String getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName='" + facultyName + '\'' +
                ", groups=" + groups +
                '}';
    }
}