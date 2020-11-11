package ErrorsAndExceptions;

import ErrorsAndExceptions.classes.Faculty;
import ErrorsAndExceptions.classes.Group;
import ErrorsAndExceptions.classes.Mark;
import ErrorsAndExceptions.classes.Student;
import ErrorsAndExceptions.exceptions.*;
import ErrorsAndExceptions.methods.University;
import static ErrorsAndExceptions.classes.Subject.*;

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
                                new Mark(ЛОГИСТИКА, 6), new Mark(МАРКЕТИНГ, 6),
                                new Mark(ПОЛИТОЛОГИЯ, 4), new Mark(СТАТИСТИКА, 10),
                                new Mark(ПСИХОЛОГИЯ, 9))),
                        new Student("Иванов Андрей", Arrays.asList(
                                new Mark(ЛОГИСТИКА, 10), new Mark(МАРКЕТИНГ, 4),
                                new Mark(ПОЛИТОЛОГИЯ, 6), new Mark(СТАТИСТИКА, 5),
                                new Mark(ПСИХОЛОГИЯ, 7), new Mark (ФИЛОСОФИЯ, 7))))),
                new Group ("МТ-11", Arrays.<Student>asList(
                        new Student("Смирнов Леонид", Arrays.asList(
                                new Mark(ЛОГИСТИКА, 5), new Mark(МАРКЕТИНГ, 9),
                                new Mark(СТАТИСТИКА, 4), new Mark(ФИЛОСОФИЯ, 5),
                                new Mark(ПСИХОЛОГИЯ, 6))),
                        new Student("Кузнецова Алеся", Arrays.asList(
                                new Mark(ЛОГИСТИКА, 8), new Mark(МАРКЕТИНГ, 4),
                                new Mark(ПОЛИТОЛОГИЯ, 5), new Mark(СТАТИСТИКА, 9),
                                new Mark(ПСИХОЛОГИЯ, 7),new Mark (ФИЛОСОФИЯ, 5))))))));
        technicalUniversity.add(new Faculty("Факультет автоматизированных и информационных систем", Arrays.asList(
                new Group("ИТП-11", Arrays.asList(
                        new Student("Михайлов Сергей", Arrays.asList(
                                new Mark(ФИЛОСОФИЯ, 6), new Mark(ОС, 4), new Mark(ООП, 8),
                                new Mark(БД, 9), new Mark(ПОЛИТОЛОГИЯ, 10), new Mark(ПСИХОЛОГИЯ, 9))),
                        new Student("Новикова Диана", Arrays.asList(
                                new Mark(ФИЛОСОФИЯ, 4), new Mark(ОС, 7), new Mark(ООП, 9),
                                new Mark(БД, 7), new Mark(ПОЛИТОЛОГИЯ, 4),
                                new Mark(ПСИХОЛОГИЯ, 6))))),
                new Group("ИТИ-11", Arrays.asList(
                        new Student("Егоров Дмитрий", Arrays.asList(
                                new Mark(ФИЛОСОФИЯ, 4), new Mark(ОС, 6), new Mark(ООП, 10),
                                new Mark(БД, 7), new Mark(ПОЛИТОЛОГИЯ, 5), new Mark(ПСИХОЛОГИЯ, 8))),
                        new Student("Степанова Нина", Arrays.asList(
                                new Mark(ФИЛОСОФИЯ, 5), new Mark(ОС, 6), new Mark(ООП, 4),
                                new Mark(БД, 8), new Mark(ПОЛИТОЛОГИЯ, 9),
                                new Mark(ПСИХОЛОГИЯ, 7))))))));
        technicalUniversity.add(new Faculty("Машиностроительный факультет", Arrays.asList(
                new Group("ТМ-11", Arrays.asList(
                        new Student("Морозов Виталий", Arrays.asList(
                                new Mark(ТЕХНОЛОГИЯ_МАТЕРИАЛОВ, 4), new Mark(МАТЕРИАЛОВЕДЕНИЕ, 5),
                                new Mark(ТЕОРИЯ_РЕЗАНИЯ, 5), new Mark(ПСИХОЛОГИЯ, 8),
                                new Mark(ФИЛОСОФИЯ, 8), new Mark(ПОЛИТОЛОГИЯ, 9))),
                        new Student("Волкова Алина", Arrays.asList(
                                new Mark(ТЕХНОЛОГИЯ_МАТЕРИАЛОВ, 5), new Mark(МАТЕРИАЛОВЕДЕНИЕ, 6),
                                new Mark(ТЕОРИЯ_РЕЗАНИЯ, 4), new Mark(ПСИХОЛОГИЯ, 10),
                                new Mark(ФИЛОСОФИЯ, 7), new Mark(ПОЛИТОЛОГИЯ, 8))))),
                new Group("МС-12", Arrays.asList(
                        new Student("Захаров Никита", Arrays.asList(
                                new Mark(ТЕХНОЛОГИЯ_МАТЕРИАЛОВ, 5), new Mark(МАТЕРИАЛОВЕДЕНИЕ, 5),
                                new Mark(ТЕОРИЯ_РЕЗАНИЯ, 6), new Mark(ПСИХОЛОГИЯ, 4),
                                new Mark(ФИЛОСОФИЯ, 8), new Mark(ПОЛИТОЛОГИЯ, 7))),
                        new Student("Лебедев Михаил", Arrays.asList(
                                new Mark(ТЕХНОЛОГИЯ_МАТЕРИАЛОВ, 8), new Mark(МАТЕРИАЛОВЕДЕНИЕ, 9),
                                new Mark(ТЕОРИЯ_РЕЗАНИЯ, 7), new Mark(ПСИХОЛОГИЯ, 6),
                                new Mark(ФИЛОСОФИЯ, 8), new Mark(ПОЛИТОЛОГИЯ, 5))))))));

            University university = new University(technicalUniversity);
            University.printAverageScoreForEachStudent();
            University.printAverageScoreForEachSubject();
            University.printAverageScoreInSubjectAtFacultyAndInGroup();

        } catch (NoFacultiesInTheUniversityException | NoGroupsAtTheFacultyException | NoStudentsInTheGroupException |
                NoSubjectsForStudentException | MarkOutOfBoundException e) {
            System.err.println(e);
        }
    }
}
