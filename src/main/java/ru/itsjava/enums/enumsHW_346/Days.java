package ru.itsjava.enums.enumsHW_346;

public enum Days {
    Sunday("Воскресение"), Monday("Понедельник"),
    Tuesday("Вторник"), Wednesday("Среда"),
    Friday("Пятница"), Saturday("Суббота");

    final String translate;

    Days(String translate) {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return "Days{" + name() +
                " (translate='" + translate +
                "')}";
    }

    public  String getTranslate(){
     return translate;
    }
}
