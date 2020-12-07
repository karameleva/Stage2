package karameleva.exceptions.classes;

import karameleva.exceptions.exceptions.*;

import java.util.*;

public class University {
    private String universityName;
    private List<Faculty> faculties;

    public University(String universityName) {
        this.universityName = universityName;
        this.faculties = setFaculties();
    }

    public Student getStudent(String studentName) throws NoStudentsInTheGroupException, NoStudentAtTheUniversityException {
        for (Faculty faculty : faculties) {
            Student student = faculty.getStudentAtTheFaculty(studentName);
            if (student!= null) {
                return student;
            }
        }
        throw new NoStudentAtTheUniversityException("Required student isn't found at the university");
    }

    public Group getGroup(String requiredGroupName) throws NoFacultiesInTheUniversityException, NoGroupsAtTheFacultyException, NoRequiredGroupException {
        if (faculties.isEmpty()) {
            throw new NoFacultiesInTheUniversityException("Faculties at the University " + universityName + "aren't found");
        }
        for (Faculty faculty : faculties) {
            try {
                Group group = faculty.getGroup(requiredGroupName);
                if (group != null) {
                    return group;
                }
            } catch (NoRequiredGroupException e) { }
        }
        throw new NoRequiredGroupException("Group '" + requiredGroupName + "' isn't found");
    }

    public Faculty getFaculty(String requiredFacultyName) throws NoFacultiesInTheUniversityException, NoRequiredFacultyAtTheUniversityException {
        if (faculties.isEmpty()) {
            throw new NoFacultiesInTheUniversityException("Faculties at the University " + universityName + "aren't found");
        }
        for (Faculty faculty : faculties) {
           if (faculty.getFacultyName().toLowerCase().equals(requiredFacultyName.toLowerCase())){
               return faculty;
           }
        }
    throw new NoRequiredFacultyAtTheUniversityException("Faculty '" + requiredFacultyName + "' isn't found at the University");
    }

    public double getAverageScoreForSubjectAtUniversity(String requiredSubject) throws NoFacultiesInTheUniversityException,
            NoStudentsInTheGroupException, NoGroupsAtTheFacultyException, NoSubjectsForStudentException, RequiredSubjectDoesNotExistException, NoRequiredSubjectException {
        if (faculties.isEmpty()) {
            throw new NoFacultiesInTheUniversityException("Faculties at the University " + universityName + "aren't found");
        }
        double total = 0;
        int amount = 0;
        for (Faculty faculty : faculties) {
            try {
                total += faculty.getAverageScoreForSubjectAtFaculty(requiredSubject);
                amount ++;
            } catch (NoRequiredSubjectException e) { }
        }
        if (amount != 0) {
            return total/amount;
        }
        throw new NoRequiredSubjectException("Marks for subject '" + requiredSubject + "' aren't found");
    }

    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    public List<Faculty> getFaculties() throws NoFacultiesInTheUniversityException {
        if (faculties.isEmpty()) {
            throw new NoFacultiesInTheUniversityException("В университете нет факультетов");
        }
        return faculties;
    }

    public List<Faculty> setFaculties() {
        List<Faculty> faculties = new ArrayList<>();
        return faculties;
    }
}