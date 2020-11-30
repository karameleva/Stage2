package karameleva.exceptions.classes;

public enum Subject {
    PSYCHOLOGY ("Психология"), PHILOSOPHY("Философия"), SOCIOLOGY ("Социология"),
    LOGISTICS ("Логистика"), MARKETING("Маркетинг"), STATISTICS("Статистика"),
    OS ("Операционные системы"), OOP ("Объектно-ориентированное программирование"),
    DB ("Базы данных"), MATERIALS_TECHNOLOGY ("Технология материалов"),
    MATERIALS_SCIENCE ("Материаловедение"), CUTTING_THEORY("Теория резания");

    String realName;

    Subject(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return realName;
    }
}
