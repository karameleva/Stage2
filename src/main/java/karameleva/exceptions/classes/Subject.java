package karameleva.exceptions.classes;

public enum Subject {
    PSYCHOLOGY ("Психология"), PHILOSOPHY("Философия"), SOCIOLOGY ("Социология"),
    LOGISTICS ("Логистика"), MARKETING("Маркетинг"), STATISTICS("Статистика"),
    OS ("Операционные системы"), OOP ("Объектно-ориентированное программирование"),
    DB ("Базы данных");

    String realName;

    Subject(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public static boolean contains(String requiredSubjectName) {
        for (Subject subject : Subject.values()) {
            if (subject.getRealName().toLowerCase().equals(requiredSubjectName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return realName;
    }
}
