package ru.tayrinn.firstlessons;

/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 01.11.17
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 */
public class HOUS_ANIMALS {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat cat=new Cat();
        cat.owner=new Woman();
        Dog dog=new Dog();
        dog.owner=new Woman();
        Fish fish=new Fish();
        fish.owner= new Woman();
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
