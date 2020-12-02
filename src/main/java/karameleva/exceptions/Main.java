package karameleva.exceptions;

import karameleva.exceptions.classes.*;
import karameleva.exceptions.exceptions.*;
import static karameleva.exceptions.classes.Subject.*;

import java.util.Arrays;

public class Main {
    public static void main( String[] args ) {
        try {
            Student student01 = new Student("Сидоров Антон", Arrays.asList(new Mark(LOGISTICS, 6),
                    new Mark(MARKETING, 6), new Mark(SOCIOLOGY, 4), new Mark(STATISTICS, 10),
                    new Mark(PSYCHOLOGY, 9)));
            Student student02 = new Student("Иванов Андрей", Arrays.asList(new Mark(LOGISTICS, 10),
                    new Mark(MARKETING, 4), new Mark(SOCIOLOGY, 6), new Mark(STATISTICS, 5),
                    new Mark(PSYCHOLOGY, 7), new Mark (PHILOSOPHY, 7)));
            Student student03 = new Student("Смирнов Леонид", Arrays.asList(new Mark(LOGISTICS, 5),
                    new Mark(MARKETING, 9), new Mark(STATISTICS, 4), new Mark(PHILOSOPHY, 5),
                    new Mark(PSYCHOLOGY, 6)));
            Student student04 = new Student("Кузнецова Алеся", Arrays.asList(new Mark(LOGISTICS, 8),
                    new Mark(MARKETING, 4), new Mark(SOCIOLOGY, 5), new Mark(STATISTICS, 9),
                    new Mark(PSYCHOLOGY, 7), new Mark (PHILOSOPHY, 5)));
            Student student05 = new Student("Михайлов Сергей", Arrays.asList(new Mark(PHILOSOPHY, 6),
                    new Mark(OS, 4), new Mark(OOP, 8), new Mark(DB, 9), new Mark(SOCIOLOGY, 10),
                    new Mark(PSYCHOLOGY, 9)));
            Student student06 = new Student("Новикова Диана", Arrays.asList(new Mark(PHILOSOPHY, 4),
                    new Mark(OS, 7), new Mark(OOP, 9), new Mark(DB, 7), new Mark(SOCIOLOGY, 4),
                    new Mark(PSYCHOLOGY, 6)));
            Student student07 = new Student("Егоров Дмитрий", Arrays.asList(new Mark(PHILOSOPHY, 4),
                    new Mark(OS, 6), new Mark(OOP, 10),new Mark(DB, 7), new Mark(SOCIOLOGY, 5),
                    new Mark(PSYCHOLOGY, 8)));
            Student student08 = new Student("Степанова Нина", Arrays.asList(new Mark(PHILOSOPHY, 5),
                    new Mark(OS, 6), new Mark(OOP, 4),new Mark(DB, 8), new Mark(SOCIOLOGY, 9),
                    new Mark(PSYCHOLOGY, 7)));
            Student student09 = new Student("Морозов Виталий", Arrays.asList(new Mark(MATERIALS_TECHNOLOGY, 4),
                    new Mark(MATERIALS_SCIENCE, 5), new Mark(CUTTING_THEORY, 5), new Mark(PSYCHOLOGY, 8),
                    new Mark(PHILOSOPHY, 8), new Mark(SOCIOLOGY, 9)));
            Student student10 = new Student("Волкова Алина", Arrays.asList(new Mark(MATERIALS_TECHNOLOGY, 5),
                    new Mark(MATERIALS_SCIENCE, 6), new Mark(CUTTING_THEORY, 4), new Mark(PSYCHOLOGY, 10),
                    new Mark(PHILOSOPHY, 7), new Mark(SOCIOLOGY, 8)));
            Student student11 = new Student("Захаров Никита", Arrays.asList(new Mark(MATERIALS_TECHNOLOGY, 5),
                    new Mark(MATERIALS_SCIENCE, 5), new Mark(CUTTING_THEORY, 6), new Mark(PSYCHOLOGY, 4),
                    new Mark(PHILOSOPHY, 8), new Mark(SOCIOLOGY, 7)));
            Student student12 = new Student("Лебедев Михаил", Arrays.asList(new Mark(MATERIALS_TECHNOLOGY, 8),
                    new Mark(MATERIALS_SCIENCE, 9),new Mark(CUTTING_THEORY, 7), new Mark(PSYCHOLOGY, 6),
                    new Mark(PHILOSOPHY, 8), new Mark(SOCIOLOGY, 5)));

            Group mg12 = new Group("MГ-12", Arrays.asList(student01, student02));
            Group mt12 = new Group("МТ-12", Arrays.asList(student03, student04));
            Group itp11 = new Group("ИТП-11", Arrays.asList(student05, student06));
            Group iti11 = new Group("ИТИ-11", Arrays.asList(student07, student08));
            Group tm11 = new Group("ТМ-11", Arrays.asList(student09, student10));
            Group ms12 = new Group("МС-12", Arrays.asList(student11, student12));

            Faculty gef = new Faculty("Гуманитарно-экономический факультет", Arrays.asList(mg12, mt12));
            Faculty fais = new Faculty("Факультет автоматизированных и информационных систем", Arrays.asList(itp11, iti11));
            Faculty msf = new Faculty("Машиностроительный факультет", Arrays.asList(tm11, ms12));

            University technicalUniversity = new University(Arrays.asList(gef, fais, msf));

            System.out.println("Средний балл студента " + student10.getStudentName() + " - "
                    + String.format("%.2f" , student10.getAverageScoreForStudent()));
            System.out.println("Средний балл по предмету '" + OS + "' в группе '" + iti11 + "' на факультете '" + fais
                    + "' - " + String.format("%.2f" , fais.getAverageScoreForSubjectInGroupAtFaculty(OS, iti11)));
            System.out.println("Средний балл по предмету '" + SOCIOLOGY + "' в университете - "
                    + String.format("%.2f" ,technicalUniversity.getAverageScoreForSubjectAtUniversity(SOCIOLOGY)));

        } catch (NoFacultiesInTheUniversityException | NoGroupsAtTheFacultyException | NoStudentsInTheGroupException |
                NoSubjectsForStudentException | MarkOutOfBoundException | NoGroupAtTheFacultyException e) {
            System.err.println(e);
        }
    }
}
