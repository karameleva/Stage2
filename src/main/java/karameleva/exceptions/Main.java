package karameleva.exceptions;

import karameleva.exceptions.classes.*;
import karameleva.exceptions.exceptions.*;
import karameleva.exceptions.methods.University;

import static karameleva.exceptions.classes.Subject.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main( String[] args ) {
        try {
        List <Faculty> technicalUniversity = new ArrayList<>();
        technicalUniversity.add(new Faculty("Гуманитарно-экономический факультет", Arrays.asList(
                new Group("МГ-12", Arrays.asList(
                        new Student("Сидоров Антон", Arrays.asList(
                                new Mark(LOGISTICS, 6), new Mark(MARKETING, 6),
                                new Mark(SOCIOLOGY, 4), new Mark(STATISTICS, 10),
                                new Mark(PSYCHOLOGY, 9))),
                        new Student("Иванов Андрей", Arrays.asList(
                                new Mark(LOGISTICS, 10), new Mark(MARKETING, 4),
                                new Mark(SOCIOLOGY, 6), new Mark(STATISTICS, 5),
                                new Mark(PSYCHOLOGY, 7), new Mark (PHILOSOPHY, 7))))),
                new Group ("МТ-11", Arrays.<Student>asList(
                        new Student("Смирнов Леонид", Arrays.asList(
                                new Mark(LOGISTICS, 5), new Mark(MARKETING, 9),
                                new Mark(STATISTICS, 4), new Mark(PHILOSOPHY, 5),
                                new Mark(PSYCHOLOGY, 6))),
                        new Student("Кузнецова Алеся", Arrays.asList(
                                new Mark(LOGISTICS, 8), new Mark(MARKETING, 4),
                                new Mark(SOCIOLOGY, 5), new Mark(STATISTICS, 9),
                                new Mark(PSYCHOLOGY, 7),new Mark (PHILOSOPHY, 5))))))));
        technicalUniversity.add(new Faculty("Факультет автоматизированных и информационных систем", Arrays.asList(
                new Group("ИТП-11", Arrays.asList(
                        new Student("Михайлов Сергей", Arrays.asList(
                                new Mark(PHILOSOPHY, 6), new Mark(OS, 4), new Mark(OOP, 8),
                                new Mark(DB, 9), new Mark(SOCIOLOGY, 10), new Mark(PSYCHOLOGY, 9))),
                        new Student("Новикова Диана", Arrays.asList(
                                new Mark(PHILOSOPHY, 4), new Mark(OS, 7), new Mark(OOP, 9),
                                new Mark(DB, 7), new Mark(SOCIOLOGY, 4),
                                new Mark(PSYCHOLOGY, 6))))),
                new Group("ИТИ-11", Arrays.asList(
                        new Student("Егоров Дмитрий", Arrays.asList(
                                new Mark(PHILOSOPHY, 4), new Mark(OS, 6), new Mark(OOP, 10),
                                new Mark(DB, 7), new Mark(SOCIOLOGY, 5), new Mark(PSYCHOLOGY, 8))),
                        new Student("Степанова Нина", Arrays.asList(
                                new Mark(PHILOSOPHY, 5), new Mark(OS, 6), new Mark(OOP, 4),
                                new Mark(DB, 8), new Mark(SOCIOLOGY, 9),
                                new Mark(PSYCHOLOGY, 7))))))));
        technicalUniversity.add(new Faculty("Машиностроительный факультет", Arrays.asList(
                new Group("ТМ-11", Arrays.asList(
                        new Student("Морозов Виталий", Arrays.asList(
                                new Mark(MATERIALS_TECHNOLOGY, 4), new Mark(MATERIALS_SCIENCE, 5),
                                new Mark(CUTTING_THEORY, 5), new Mark(PSYCHOLOGY, 8),
                                new Mark(PHILOSOPHY, 8), new Mark(SOCIOLOGY, 9))),
                        new Student("Волкова Алина", Arrays.asList(
                                new Mark(MATERIALS_TECHNOLOGY, 5), new Mark(MATERIALS_SCIENCE, 6),
                                new Mark(CUTTING_THEORY, 4), new Mark(PSYCHOLOGY, 10),
                                new Mark(PHILOSOPHY, 7), new Mark(SOCIOLOGY, 8))))),
                new Group("МС-12", Arrays.asList(
                        new Student("Захаров Никита", Arrays.asList(
                                new Mark(MATERIALS_TECHNOLOGY, 5), new Mark(MATERIALS_SCIENCE, 5),
                                new Mark(CUTTING_THEORY, 6), new Mark(PSYCHOLOGY, 4),
                                new Mark(PHILOSOPHY, 8), new Mark(SOCIOLOGY, 7))),
                        new Student("Лебедев Михаил", Arrays.asList(
                                new Mark(MATERIALS_TECHNOLOGY, 8), new Mark(MATERIALS_SCIENCE, 9),
                                new Mark(CUTTING_THEORY, 7), new Mark(PSYCHOLOGY, 6),
                                new Mark(PHILOSOPHY, 8), new Mark(SOCIOLOGY, 5))))))));

            University university = new University(technicalUniversity);
            university.printAverageScoreForEachStudent();
            university.printAverageScoreForEachSubject();
            university.printAverageScoreInSubjectAtFacultyAndInGroup();

        } catch (NoFacultiesInTheUniversityException | NoGroupsAtTheFacultyException | NoStudentsInTheGroupException |
                NoSubjectsForStudentException | MarkOutOfBoundException e) {
            System.err.println(e);
        }
    }
}
