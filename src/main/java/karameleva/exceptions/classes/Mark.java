package karameleva.exceptions.classes;

import karameleva.exceptions.exceptions.MarkOutOfBoundException;

public class Mark {
    private Subject subject;
    private int mark;

    public Mark(Subject subject, int mark) throws MarkOutOfBoundException {
        if (mark < 0 || mark > 10) {
            throw new MarkOutOfBoundException("Неверно введена оценка");
        }
        this.subject = subject;
        this.mark = mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return subject.realName + " - " + String.format ("%.2f", mark);
    }
}
