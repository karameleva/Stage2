package ErrorsAndExceptions.methods;

import ErrorsAndExceptions.classes.Faculty;
import ErrorsAndExceptions.classes.Group;
import ErrorsAndExceptions.classes.Mark;
import ErrorsAndExceptions.classes.Student;
import ErrorsAndExceptions.exceptions.NoFacultiesInTheUniversityException;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class University {

    private static List<?extends Faculty> technicalUniversity;

    public University(List <?extends Faculty> technicalUniversity) throws NoFacultiesInTheUniversityException {
        University.technicalUniversity = technicalUniversity;
        if (technicalUniversity.isEmpty()) {
            throw new NoFacultiesInTheUniversityException("В университете нет факультетов");
        }
    }

    public static void printAverageScoreForEachStudent() {

        System.out.println("\n------------------------------------------------" +
                "\nСредний балл по всем предметам каждого студента:" +
                "\n------------------------------------------------");
        for (Faculty faculty : technicalUniversity) {
            System.out.println("\n" + faculty.getFacultyName());
            for (Group group : faculty.getGroups()) {
                System.out.println("\n" + group.getGroupName());
                for (Student student : group.getStudents()) {
                    double sum = 0;
                    int i = 0;
                    for (Mark mark:student.getMarks()) {
                        sum += mark.getMark();
                        i++;
                    }
                    System.out.println(student.getStudentName() + " - " + String.format ("%.2f", (sum/i)));
                }
                }
            }
        }

    public static void printAverageScoreForEachSubject () {

        System.out.println("\n--------------------------------------------------------" +
                "\nСредний балл по каждому предмету для всего университета: " +
                "\n--------------------------------------------------------\n");
        Set<String> subjects = University.getSubjectsSet();

        for (String subject : subjects) {
            double sum = 0;
            int i = 0;

            for (Faculty faculty : technicalUniversity) {
                for (Group group : faculty.getGroups()) {
                    for (Student student : group.getStudents()) {
                        for (Mark mark : student.getMarks()) {
                            if (subject == mark.getSubject().toString()) {
                                sum += mark.getMark();
                                i++;
                            }
                        }
                    }
                }
            }
            System.out.println(subject + " - " + String.format ("%.2f", (sum/i)) + ";");
        }
    }

    public static void printAverageScoreInSubjectAtFacultyAndInGroup()  {
        System.out.println("\n-----------------------------------------------" +
                "\nСредний балл по конкретному предмету " +
                "\nв конкретной группе и на конкретном факультете:" +
                "\n-----------------------------------------------");
        Set <String> subjects = getSubjectsSet();
        String subject = getRequiredElement("предмет", subjects);

        Set <String> faculties = getFacultiesSetWithSubject(subject);
        String faculty = getRequiredElement("факультет", faculties);
        double averageScoreInSubjectAtFaculty = getAverageMark(subject, faculty);

        Set <String> groups = getGroupsSetWithSubjectAndFaculty(subject, faculty);
        String group = getRequiredElement("группу", groups);
        double averageScoreInSubjectAtFacultyAndInGroup = getAverageMark(subject, faculty, group);

        System.out.println("\nСредний балл по предмету '" + subject + "' на факультете '" + faculty +
                "' составляет " + String.format ("%.2f", averageScoreInSubjectAtFaculty));
        System.out.println("\nСредний балл по предмету '" + subject + "' на факультете '" + faculty + "' в группе '" +
                group + "' составляет " + String.format ("%.2f", averageScoreInSubjectAtFacultyAndInGroup));
    }

    public static Set <String> getSubjectsSet () {
        Set <String> subjectsSet = new HashSet<>();
        for (Faculty faculty : technicalUniversity) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    for (Mark mark:student.getMarks()) {
                        subjectsSet.add(mark.getSubject().toString());
                    }
                }
            }
        }
        return subjectsSet;
    }


    public static Set <String> getFacultiesSetWithSubject(String subject)  {
        Set <String> faculties = new HashSet<>();
        for (Faculty faculty : technicalUniversity) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    for (Mark mark : student.getMarks()) {
                        if (subject == mark.getSubject().toString()) {
                            faculties.add(faculty.getFacultyName());
                        }
                    }
                }
            }
        }
        return faculties;
    }

    public static Set <String> getGroupsSetWithSubjectAndFaculty (String subject, String faculty){
        Set<String> groupsSet = new HashSet<>();
        for (Faculty facultyElem : technicalUniversity) {
            if (facultyElem.getFacultyName() == faculty) {
                for (Group group : facultyElem.getGroups()) {
                    for (Student student : group.getStudents()) {
                        for (Mark mark : student.getMarks()) {
                            if (mark.getSubject().toString() == subject) {
                                groupsSet.add(group.getGroupName());
                                }
                            }
                        }
                    }
                }
            }
        return groupsSet;
    }

    public static String getRequiredElement(String elementName, Set <String> elementSet) {
        System.out.println("\nВыберите " + elementName + " : ");
        int i = 0;
        for (String string : elementSet) {
            System.out.println(i+1 + ". " + string);
            i++;
        }
        System.out.println("Введите соответствующий номер: ");
        Scanner scan = new Scanner(System.in);
        int stringNumber = scan.nextInt();
        while (stringNumber <=0 || stringNumber > elementSet.size()) {
            System.out.println("Неверно введены данные. Введите соответствующий номер ещё раз:   ");
            stringNumber = scan.nextInt();
        }
        String requiredElement =  elementSet.toArray()[stringNumber-1].toString();
        return requiredElement;
    }

    public static double getAverageMark (String subject, String faculty)  {
        double sum = 0;
        int i = 0;
        for (Faculty facultyElem : technicalUniversity) {
            if (facultyElem.getFacultyName() == faculty) {
                for (Group group : facultyElem.getGroups()) {
                    for (Student student : group.getStudents()) {
                        for (Mark mark : student.getMarks()) {
                            if (subject == mark.getSubject().toString()) {
                                sum += mark.getMark();
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return sum/i;
    }

    public static double getAverageMark (String subject, String faculty, String group)  {
        double sum = 0;
        int i = 0;

        for (Faculty facultyElem : technicalUniversity) {
            if (facultyElem.getFacultyName() == faculty) {
                for (Group groupElem : facultyElem.getGroups()) {
                    if (groupElem.getGroupName() == group) {
                       for (Student student : groupElem.getStudents()) {
                           for (Mark mark : student.getMarks()) {
                               if (subject == mark.getSubject().toString()) {
                                   sum += mark.getMark();
                                   i++;
                               }
                           }
                       }
                    }
                }
            }

        }
        return sum/i;
    }
}
