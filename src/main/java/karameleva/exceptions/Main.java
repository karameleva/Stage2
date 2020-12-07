package karameleva.exceptions;

import karameleva.exceptions.classes.*;
import karameleva.exceptions.exceptions.*;
import static karameleva.exceptions.classes.Subject.*;

public class Main {
    public static void main( String[] args ) {
        try {
            Student studentSidorovAnton = new Student("Сидоров Антон");

            studentSidorovAnton.addMark(new Mark(LOGISTICS, 6));
            studentSidorovAnton.addMark(new Mark(MARKETING, 6));
            studentSidorovAnton.addMark(new Mark(SOCIOLOGY, 4));
            studentSidorovAnton.addMark(new Mark(STATISTICS, 10));
            studentSidorovAnton.addMark(new Mark(PSYCHOLOGY, 9));

            Student studentIvanovAndrey = new Student("Иванов Андрей");

            studentIvanovAndrey.addMark(new Mark(LOGISTICS, 10));
            studentIvanovAndrey.addMark(new Mark(MARKETING, 4));
            studentIvanovAndrey.addMark(new Mark(SOCIOLOGY, 6));
            studentIvanovAndrey.addMark(new Mark(STATISTICS, 5));
            studentIvanovAndrey.addMark(new Mark(PSYCHOLOGY, 7));
            studentIvanovAndrey.addMark(new Mark(PHILOSOPHY, 7));

            Student studentSmirnovLeonid = new Student("Смирнов Леонид");

            studentSmirnovLeonid.addMark(new Mark(LOGISTICS, 5));
            studentSmirnovLeonid.addMark(new Mark(MARKETING, 9));
            studentSmirnovLeonid.addMark(new Mark(STATISTICS, 4));
            studentSmirnovLeonid.addMark(new Mark(PHILOSOPHY, 5));
            studentSmirnovLeonid.addMark(new Mark(PSYCHOLOGY, 6));

            Student studentKuznecovaAlesia = new Student("Кузнецова Алеся");

            studentKuznecovaAlesia.addMark(new Mark(LOGISTICS, 8));
            studentKuznecovaAlesia.addMark(new Mark(MARKETING, 4));
            studentKuznecovaAlesia.addMark(new Mark(SOCIOLOGY, 5));
            studentKuznecovaAlesia.addMark(new Mark(STATISTICS, 9));
            studentKuznecovaAlesia.addMark(new Mark(PSYCHOLOGY, 7));
            studentKuznecovaAlesia.addMark(new Mark(PHILOSOPHY, 5));

            Student studentMihaylovSergey = new Student("Михайлов Сергей");

            studentMihaylovSergey.addMark(new Mark(PHILOSOPHY, 6));
            studentMihaylovSergey.addMark(new Mark(OS, 4));
            studentMihaylovSergey.addMark(new Mark(OOP, 8));
            studentMihaylovSergey.addMark(new Mark(DB, 9));
            studentMihaylovSergey.addMark(new Mark(SOCIOLOGY, 10));
            studentMihaylovSergey.addMark(new Mark(PSYCHOLOGY, 9));

            Student studentNovikovaDiana = new Student("Новикова Диана");

            studentNovikovaDiana.addMark(new Mark(PHILOSOPHY, 4));
            studentNovikovaDiana.addMark(new Mark(OS, 7));
            studentNovikovaDiana.addMark(new Mark(OOP, 9));
            studentNovikovaDiana.addMark(new Mark(DB, 7));
            studentNovikovaDiana.addMark(new Mark(SOCIOLOGY, 4));
            studentNovikovaDiana.addMark(new Mark(PSYCHOLOGY, 6));

            Student studentEgorovDmitriy = new Student("Егоров Дмитрий");

            studentEgorovDmitriy.addMark(new Mark(PHILOSOPHY, 4));
            studentEgorovDmitriy.addMark(new Mark(OS, 6));
            studentEgorovDmitriy.addMark(new Mark(OOP, 10));
            studentEgorovDmitriy.addMark(new Mark(DB, 7));
            studentEgorovDmitriy.addMark(new Mark(SOCIOLOGY, 5));
            studentEgorovDmitriy.addMark(new Mark(PSYCHOLOGY, 8));

            Student studentStepanovaNina = new Student("Степанова Нина");

            studentStepanovaNina.addMark(new Mark(PHILOSOPHY, 5));
            studentStepanovaNina.addMark(new Mark(OS, 6));
            studentStepanovaNina.addMark(new Mark(OOP, 4));
            studentStepanovaNina.addMark(new Mark(DB, 8));
            studentStepanovaNina.addMark(new Mark(SOCIOLOGY, 9));
            studentStepanovaNina.addMark(new Mark(PSYCHOLOGY, 7));

            Group mg12Group = new Group("MГ-12");
            mg12Group.addStudent(studentSidorovAnton);
            mg12Group.addStudent(studentIvanovAndrey);

            Group mt12Group = new Group("МТ-12");
            mt12Group.addStudent(studentSmirnovLeonid);
            mt12Group.addStudent(studentKuznecovaAlesia);

            Group itp11Group = new Group("ИТП-11");
            itp11Group.addStudent(studentMihaylovSergey);
            itp11Group.addStudent(studentNovikovaDiana);

            Group iti11Group = new Group("ИТИ-11");
            iti11Group.addStudent(studentEgorovDmitriy);
            iti11Group.addStudent(studentStepanovaNina);

            Faculty gefFaculty = new Faculty("ГЭФ");
            gefFaculty.addGroup(mg12Group);
            gefFaculty.addGroup(mt12Group);

            Faculty faisFaculty = new Faculty("ФАИС");
            faisFaculty.addGroup(itp11Group);
            faisFaculty.addGroup(iti11Group);

            University technicalUniversity = new University("Технический университет");
            technicalUniversity.addFaculty(gefFaculty);
            technicalUniversity.addFaculty(faisFaculty);

            System.out.println("Средний балл студента Степанова Нина - " + String.format("%.2f",
                    technicalUniversity.getStudent("СТЕПАНОВА Нина").getAverageScoreForStudent()));
            System.out.println("Средний балл по философии в группе ИТИ-11 - " + String.format("%.2f",
                    technicalUniversity.getGroup("ИТИ-11").getAverageScoreForSubjectAtGroup("философия")));
            System.out.println("Средний балл по статистике на факультете ГЭФ - " + String.format("%.2f",
                    technicalUniversity.getFaculty("гэф").getAverageScoreForSubjectAtFaculty("статистика")));
            System.out.println("Средний балл по операционным системам в университете - " + String.format("%.2f",
                    technicalUniversity.getAverageScoreForSubjectAtUniversity("операционные системы")));

        } catch (NoSubjectsForStudentException | MarkOutOfBoundException | NoStudentAtTheUniversityException |
                NoStudentsInTheGroupException | NoRequiredSubjectException | NoRequiredFacultyAtTheUniversityException |
                NoGroupsAtTheFacultyException | NoRequiredGroupException | NoFacultiesInTheUniversityException |
                RequiredSubjectDoesNotExistException e) {
            e.printStackTrace();
        }
    }
}
