package ru.itsjava.itsjava_01.OOP;

public class Lion extends Cat {
    //Поля (final) - характеризуется состояние объекта
    private String name;


    //конструктор (по умолчанию) - то каким образом создаем объект
    public Lion() {

    }

    public Lion(String paramName) {
        this.name = paramName;
    }

    //методы - поведение объекта
    public void sayR() {
        System.out.println(name + " RRRRRRR");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
