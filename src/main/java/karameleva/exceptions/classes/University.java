package karameleva.exceptions.classes;

import karameleva.exceptions.exceptions.NoFacultiesInTheUniversityException;

import java.util.*;

public class University {
    private List<Faculty> faculties;

    public University(List<Faculty> faculties) throws NoFacultiesInTheUniversityException {
        if (faculties.isEmpty()) {
            throw new NoFacultiesInTheUniversityException("В университете нет факультетов");
        } else {
            this.faculties = faculties;
        }
    }

    public double getAverageScoreForSubjectAtUniversity (Subject subject) {
        double totalScore = 0;
        int amountOfMarks = 0;
        for (Faculty faculty : faculties) {
            for (Group group : faculty.getGroups()) {
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
        return totalScore/amountOfMarks;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}