package ru.itsjava.itsjava_01.OOP;

public class Main {

    public static void main(String[] args) {

        Lion simba = new Lion();
//        Lion nala = new Lion("nala");
//        Lion shram = new Lion();
//        Lion musafa = new Lion();
//
//        simba.sayR(); //вызывается метод по объекту - создали объект, поставили точку и вызвать конктреный метод.
//        nala.sayR();
//        simba.setName("Симба");
//        String simbaName = simba.getName();
//        System.out.println(simbaName);
//        simba.setName("Король Симба");
//        System.out.println(simba.getName());
        simba.sayMeow();
        Panther bagira = new Panther();
        bagira.sayMeow();
        bagira.goHunter();
        bagira.goHunter_1();
        Cat bagira_2 = new Panther();
        bagira_2.sayMeow();

//        Man yakov = new Man("Яков", 43);
//        yakov.hi();
//        yakov.getName();
//        yakov.setAge(44);
//        System.out.println("Скоро будет " + yakov.getAge());
//
//        Iron bot = new Iron(2000, 4400, 6);
//        System.out.println("На складе: " + bot.getQuantity() + " утюгов, мощностью " + bot.getPower() + " Вт, по цене " + bot.getPrice() + "руб.");
//        bot.getQuantity();
//        bot.setQuantity(8);
//        System.out.println("Цена " + bot.getPrice() + " руб. Кол-во: " + bot.getQuantity() + " шт.");


    }
}
