package ru.tayrinn.firstlessons;

/**
 * Created by IntelliJ IDEA.
 * User: Tay_Veter
 * Date: 29.10.17
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */
public class Person {
       public static void main(String[] args) {
        //напишите тут ваш код
        Person1 newPerson = new Person1();
        newPerson.age=22;
        System.out.println(newPerson);
    }

    public static class Person1 {
        String name;
        int age;
        int weight;
        int money;
        public Person1(){}

        public Person1(String name, int age, int weight, int money){
            this.name=name;
            this.age=age;
            this.weight=weight;
            this.money=money;
        }
    }
}


/*
Требования:
1. В классе Person объяви переменную name типа String.
2. В классе Person объяви переменную age типа int.
3. В классе Person объяви переменную weight типа int.
4. В классе Person объяви переменную money типа int.
5. В методе main создай объект Person и сразу присвой ссылку на него переменной person.
6. Должно быть объявлено 5 переменных.*/

